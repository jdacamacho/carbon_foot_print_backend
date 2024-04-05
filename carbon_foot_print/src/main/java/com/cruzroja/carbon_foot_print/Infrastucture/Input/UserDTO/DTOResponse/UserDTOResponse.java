package com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTOResponse {
    private long documentNumber;
    private String documentType;
    private String names;
    private String lastNames;
    private String personalPhone;
    private String personalEmail;
    private String username;
    private String password;
    private List<RoleDTOResponse> roles;
    private boolean state;

    public UserDTOResponse(){
        this.roles = new ArrayList<>();
    }
}
