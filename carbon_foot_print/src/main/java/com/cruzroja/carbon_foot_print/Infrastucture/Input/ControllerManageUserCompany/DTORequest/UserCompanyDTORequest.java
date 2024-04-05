package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.RoleDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserDTORequest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCompanyDTORequest extends UserDTORequest{
    @Positive(message = "companyNit number must be positive")
    @Min(value = 100000000L, message = "company Nit must have at least nine digits" )
    @Max(value = 999999999L, message = "company Nit can't have more than nine digits" )
    private long companyNit;

    @NotNull(message = "companyName can't be null")
    @NotBlank(message = "companyName can't be empty")
    private String companyName;
    private String companyPhone;
    private AddressDTORequest address;
    //private Date registrationDate;

    public UserCompanyDTORequest(){

    }

    public UserCompanyDTORequest(long documentNumber,String documentType,
                            String names, String lastNames,String personalPhone,
                            String personalEmail,String username,String password,
                            List<RoleDTORequest> roles,long companyNit,String companyName,
                            String companyPhone,AddressDTORequest address){
        super(documentNumber,documentType,
                names,lastNames,personalPhone,
                personalEmail,username,password,
                roles,true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.address = address;
        //this.registrationDate = new Date();
    }
}
