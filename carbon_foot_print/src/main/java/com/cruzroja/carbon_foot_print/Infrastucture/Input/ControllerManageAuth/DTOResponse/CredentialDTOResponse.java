package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.DTOResponse;

import com.cruzroja.carbon_foot_print.Domain.Models.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialDTOResponse {
    private String token;
    private User user;

    public CredentialDTOResponse(){
        
    }
}
