package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDTOResponse {
    private long idRole;
    private String typeRole;
    List<PermissionDTOResponse> permissions;

    public RoleDTOResponse(){
        this.permissions = new ArrayList<>();
    }
}
