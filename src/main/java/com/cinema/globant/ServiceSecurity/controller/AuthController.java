package com.cinema.globant.ServiceSecurity.controller;


import com.cinema.globant.ServiceSecurity.exceptions.ApiAuthorized;
import com.cinema.globant.ServiceSecurity.service.AuthService;
import com.cinema.globant.ServiceSecurity.util.DateUtils;
import com.cinema.globant.ServiceSecurity.validator.AuthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "security")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthValidator validator;

    @PostMapping(path = "oauth/client_credential/accesstoken",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>login(@RequestBody MultiValueMap<String,String> paramMap, @RequestParam("grant_type")String granType) throws ApiAuthorized {
        validator.validate(paramMap,granType);
        return ResponseEntity.ok(authService.login(paramMap.getFirst("client_id"),paramMap.getFirst("client_secret")));
    }
}
