package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.dto.JwtAuthenticationResponse;
import com.bingetgroup.ERP.dto.SignUpRequest;
import com.bingetgroup.ERP.dto.SigninRequest;
import com.bingetgroup.ERP.enums.Role;

import com.bingetgroup.ERP.exception.EmailTakenByOther;
import com.bingetgroup.ERP.exception.UserNotFoundException;
import com.bingetgroup.ERP.interfeces.AuthenticationService;
import com.bingetgroup.ERP.interfeces.JwtService;
import com.bingetgroup.ERP.models.Users;
import com.bingetgroup.ERP.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
       if (userRepository.findByEmail(request.getEmail()).isPresent())
           throw new EmailTakenByOther("Email is already registered.");
        var user = Users.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Invalid email or password"));

        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
