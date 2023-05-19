package com.cinema.globant.ServiceSecurity.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Movies {
    public int page;
    public ArrayList<Result> results;
}
