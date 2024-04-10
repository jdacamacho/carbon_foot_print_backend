package com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PermissionDTORequest {
    private long idPermission;
    private String name;
    private String description;

    public PermissionDTORequest(){

    }

}
