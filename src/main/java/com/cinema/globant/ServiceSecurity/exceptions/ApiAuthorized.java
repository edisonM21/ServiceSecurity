package com.cinema.globant.ServiceSecurity.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiAuthorized extends  Exception{

    public ApiAuthorized(String message){
        super(message);
    }
}
