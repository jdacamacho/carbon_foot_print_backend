package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PermissionDTOResponse {
    private long idPermission;
    private String name;
    private String description;

    public PermissionDTOResponse(){
        
    }

}
