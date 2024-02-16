package com.bingetgroup.ERP.controller;

import com.bingetgroup.ERP.dto.JwtAuthenticationResponse;
import com.bingetgroup.ERP.dto.SignUpRequest;
import com.bingetgroup.ERP.dto.SigninRequest;
import com.bingetgroup.ERP.interfeces.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private static final Logger log = LogManager.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {

        log.info("log test");
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
