package com.cinema.globant.ServiceSecurity.service;

import com.cinema.globant.ServiceSecurity.dto.JwtResponse;
import com.cinema.globant.ServiceSecurity.security.JwtIO;
import com.cinema.globant.ServiceSecurity.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtIO jwtIO;
    @Autowired
    private DateUtils dateUtils;
    @Value("${jms.jwt.token.expiresIn}")
    private int EXPIRES_IN;

    public JwtResponse login(String clientId,String clientSecret){
        JwtResponse jwt=JwtResponse.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken(clientId,clientSecret))
                .issuedAt(dateUtils.getDateMillis()+"")
                .clientId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();

        return jwt;
    }
}
