package com.cruzroja.carbon_foot_print.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credential {
    private long documentNumber;
    private String username;
    private String token;

    public Credential(){

    }
}
