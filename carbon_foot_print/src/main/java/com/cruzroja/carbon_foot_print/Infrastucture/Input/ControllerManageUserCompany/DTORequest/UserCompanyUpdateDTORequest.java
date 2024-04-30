package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserUpdateDTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCompanyUpdateDTORequest extends UserUpdateDTORequest{
    @Positive(message = "companyNit number must be positive")
    @Min(value = 100000000L, message = "company Nit must have at least nine digits" )
    @Max(value = 999999999L, message = "company Nit can't have more than nine digits" )
    private long companyNit;

    @NotNull(message = "companyName can't be null")
    @NotBlank(message = "companyName can't be empty")
    private String companyName;

    @NotNull(message = "companyPhone can't be null")
    @NotBlank(message = "companyPhone can't be empty")
    @Pattern(regexp = "(?:3[0-9]{9})|(?:[1-9][0-9]{8})", message = "companyPhone must begin with 3 and have ten digits or begin with {1-9} and have eight digits")
    private String companyPhone;

    @NotNull(message = "companyEmail can't be null")
    @NotBlank(message = "companyEmail can't be empty")
    @Email(message = "companyEmail must be valid")
    private String companyEmail;

    @Valid
    @NotNull(message = "Address can't be null")
    private AddressDTORequest address;

    public UserCompanyUpdateDTORequest(){

    }

    public UserCompanyUpdateDTORequest(long documentNumber,String documentType,
                            String names, String lastNames,String personalPhone,
                            String personalEmail,String username,
                            List<RoleWithIdDTORequest> roles,long companyNit,String companyName,
                            String companyPhone,AddressDTORequest address){
        super(documentNumber,documentType,
                names,lastNames,personalPhone,
                personalEmail,username,
                roles,true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.address = address;
    }
}