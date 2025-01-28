package com.gymapp.controller;

import com.gymapp.dtos.user.LoginRequestDTO;
import com.gymapp.dtos.user.LoginResponseDTO;
import com.gymapp.services.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AuthenticationController {

    private final TokenService tokenService;

    public AuthenticationController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {

        long expiresIn = 300L;

        String accessToken = tokenService.generateToken(request, expiresIn);

        return ResponseEntity.ok(new LoginResponseDTO(accessToken, expiresIn));
    }
}
