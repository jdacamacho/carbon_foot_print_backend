package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTOResponse;

import java.util.Date;
import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse.RoleDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTOResponse.UserDTOResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCompanyDTOResponse extends UserDTOResponse{
    private long companyNit;
    private String companyName;
    private String companyPhone;
    private AddressDTOResponse address;
    private Date registrationDate;

    public UserCompanyDTOResponse(){

    }

    public UserCompanyDTOResponse(long documentNumber,String documentType,
                            String names, String lastNames,String personalPhone,
                            String personalEmail,String username,String password,
                            List<RoleDTOResponse> roles,long companyNit,String companyName,
                            String companyPhone,AddressDTOResponse address, Date registrationDate){
        super(documentNumber,documentType,
                names,lastNames,personalPhone,
                personalEmail,username,password,
                roles,true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.address = address;
        this.registrationDate = registrationDate;
    }
}
