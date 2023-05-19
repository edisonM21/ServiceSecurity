package com.cinema.globant.ServiceSecurity.validator;

import com.cinema.globant.ServiceSecurity.exceptions.ApiAuthorized;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

@Component
public class AuthValidator {
    private static final String CLIENT_CREDENTIALS="client_credentials";


    public void validate(MultiValueMap<String,String> paramMap, String granType) throws ApiAuthorized {

        if (granType.isEmpty()||!granType.equals(CLIENT_CREDENTIALS)){
            message("El campo es invalido");
        }
        if (Objects.isNull(paramMap)||
                paramMap.getFirst("client_id").isEmpty()||
                paramMap.getFirst("client_secret").isEmpty()
        ){
            message("Client_id y/o client_secret son validos");
        }
    }

    private void message(String message) throws ApiAuthorized {
        throw  new ApiAuthorized(message);
    }
}
