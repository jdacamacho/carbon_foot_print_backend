package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialDTOResponse {
    private long documentNumber;
    private String username;
    private String token;

    public CredentialDTOResponse(){
        
    }
}
