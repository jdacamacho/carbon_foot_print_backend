package com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest;

import java.util.ArrayList;
import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleWithIdDTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTORequest {
    @Positive(message = "Document number must be positive")
    private long documentNumber;

    @NotNull(message = "Document type can't be null")
    @NotBlank(message = "Document type can't be empty")
    @Size(min = 6, max = 45, message = "Document type can't be shorter than 6 characters and longer than 45 characters")
    private String documentType;

    @NotNull(message = "names can't be null")
    @NotBlank(message = "names can't be empty")
    @Size(min = 2, max = 60, message = "Names can't be shorter than 2 characters and longer than 60 characters")
    private String names;

    @NotNull(message = "lastNames can't be null")
    @NotBlank(message = "lastNames can't be empty")
    @Size(min = 2, max = 60, message = "latNames can't be shorter than 2 characters and longer than 60 characters")
    private String lastNames;

    @Pattern(regexp = "[3][0-9]{9}", message = "Personal phone must begin with 3 and have ten digits") 
    private String personalPhone;

    @NotNull(message = "email can't be null")
    @NotBlank(message = "email can't be empty")
    @Email(message = "email must be valid")
    @Size(min = 10, max = 320, message = "personalEmail can't be shorter than 10 characters and longer than 320 characters")
    private String personalEmail;

    @NotNull(message = "username can't be null")
    @NotBlank(message = "username can't be empty")
    @Size(min = 2, max = 40, message = "username can't be shorter than 2 characters and longer than 40 characters")
    private String username;

    @NotNull(message = "password can't be null")
    @NotBlank(message = "password can't be empty")
    @Size(min = 10, max = 200, message = "password can't be shorter than 10 characters and longer than 200 characters")
    private String password;

    @Size(min = 1, message = "User must have at least one role")
    @Valid
    private List<RoleWithIdDTORequest> roles;

    @NotNull(message = "User must have a state in the system")
    private boolean state;

    public UserDTORequest(){
        this.roles = new ArrayList<>();
    }
}
