package com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(value = 1000000000L, message = "Document number must have at least ten digits" )
    @Max(value = 9999999999L, message = "Document number can't have more than ten digits" )
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
    @Size(min = 2, max = 60, message = "Names can't be shorter than 2 characters and longer than 60 characters")
    private String lastNames;

    @Pattern(regexp = "[3][0-9]{9}", message = "Personal phone must begin with 3 and have ten digits") 
    private String personalPhone;

    @NotNull(message = "email can't be null")
    @NotBlank(message = "email can't be empty")
    @Email(message = "email must be valid")
    private String personalEmail;

    @NotNull(message = "username can't be null")
    @NotBlank(message = "username can't be empty")
    private String username;

    @NotNull(message = "password can't be null")
    @NotBlank(message = "password can't be empty")
    private String password;

    @Size(min = 1, message = "User must have at least one role")
    @Valid
    private List<RoleDTORequest> roles;

    @NotNull(message = "User must have a state in the system")
    private boolean state;

    public UserDTORequest(){
        this.roles = new ArrayList<>();
    }
}
