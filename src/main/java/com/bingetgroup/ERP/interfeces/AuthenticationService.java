package com.bingetgroup.ERP.interfeces;

import com.bingetgroup.ERP.dto.JwtAuthenticationResponse;
import com.bingetgroup.ERP.dto.SignUpRequest;
import com.bingetgroup.ERP.dto.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}