package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.cruzroja.carbon_foot_print.Application.Input.ManageUserCompanyCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

public class ManageUserCompanyCUImplAdapter implements ManageUserCompanyCUIntPort {
    private final ManageUserCompanyGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;
    private final PasswordEncoder passwordEncoder;

    public ManageUserCompanyCUImplAdapter(ManageUserCompanyGatewayIntPort gateway, 
                                            ExceptionFormatterIntPort errorFormatter,
                                            PasswordEncoder passwordEncoder){
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserCompany> listUserCompany() {
        List<UserCompany> users = this.gateway.findAll();
        if(users.size() == 0){
            this.errorFormatter.returNoData("Not exists companies in the system");
        }
        return users;
    }

    @Override
    public UserCompany saveUserCompany(UserCompany userCompany) {
        UserCompany userResponse = null;

        if(this.gateway.existUserByDocumentNumberOrUsernameOrPersonalEmail(userCompany.getDocumentNumber(), userCompany.getUsername(), userCompany.getPersonalEmail())){
            this.errorFormatter.returnResponseErrorEntityExists("User duplicate");
        }else if(this.gateway.existsByCompanyNitOrCompanyEmailOrCompanyName(userCompany.getCompanyNit(), userCompany.getCompanyEmail(), userCompany.getCompanyName())){
            this.errorFormatter.returnResponseErrorEntityExists("Company duplicate");
        }else{
            if(!userCompany.isValidRoles(this.gateway.findAllRoles())){
                this.errorFormatter.returnResponseBusinessRuleViolated("Roles are not valid");
            }else if(userCompany.hasDuplicateRoles()){
                this.errorFormatter.returnResponseBusinessRuleViolated("Company has roles duplicates");
            }else{
                String newPassword = this.passwordEncoder.encode(userCompany.getPassword());
                userCompany.setPassword(newPassword);
                userCompany.setInformation();
                userResponse = this.gateway.save(userCompany);
            }
        }
       
        return userResponse;
    }

    @Override
    public UserCompany updateUserCompany( UserCompany userCompany) {
        UserCompany userResponse = null;

        if(!this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber())){
            this.errorFormatter.returnResponseErrorEntityNotFound("Company not found");
        }else{
            if(!userCompany.isValidRoles(this.gateway.findAllRoles())){
                this.errorFormatter.returnResponseBusinessRuleViolated("Roles are not valid");
            }else if(userCompany.hasDuplicateRoles()){
                this.errorFormatter.returnResponseBusinessRuleViolated("User has duplicates");
            }else{
                UserCompany userGot = this.gateway.findUserCompanyByNumberDocument(userCompany.getDocumentNumber());
                if(!IsValidUpdatingInformationUser(userGot, userCompany) ||  !IsValidUpdatingInformationCompany(userGot, userCompany)){
                    this.errorFormatter.returnResponseErrorEntityExists("User Company exists");
                }else{
                    userGot.update(userCompany);
                    userResponse = this.gateway.save(userGot);
                }
            }
        }
        
        return userResponse;
    }

    @Override
    public UserCompany getUserCompanyByNumberDocument(long numberDocument) {
        UserCompany userResponse = null;
        if(!this.gateway.existsUserCompanyByNumberDocument(numberDocument)){
            this.errorFormatter.returnResponseErrorEntityNotFound("Company not found in the system");
        }
        userResponse = this.gateway.findUserCompanyByNumberDocument(numberDocument);
        return userResponse;
    }

    @Override
    public UserCompany getUserCompanyByNit(long nitCompany) {
        UserCompany userResponse = null;
        if(!this.gateway.existsCompanyByNit(nitCompany)){
            this.errorFormatter.returnResponseErrorEntityNotFound("Company not found in the system");
        }
        userResponse = this.gateway.findByCompanyNit(nitCompany);
        return userResponse;
    }

    private boolean IsValidUpdatingInformationUser(UserCompany userObtained, UserCompany newUserCompany){
        boolean flagUser = false;
        String username = "";
        String personalEmail = "";

        if(userObtained.getUsername().equals(newUserCompany.getUsername()) == false){ username = newUserCompany.getUsername();};
        if(userObtained.getPersonalEmail().equals(newUserCompany.getPersonalEmail()) == false ){ personalEmail = newUserCompany.getPersonalEmail();};

        flagUser = this.gateway.existUserByDocumentNumberOrUsernameOrPersonalEmail(0, username, personalEmail);

        if(flagUser){
            return false;
        }

        return true;
    }

    private boolean IsValidUpdatingInformationCompany(UserCompany userObtained, UserCompany newUserCompany){
        boolean flagCompany = false;
        long companyNit = 0;
        String companyEmail = "";
        String companyName = "";

        if(userObtained.getCompanyNit() != newUserCompany.getCompanyNit()){ companyNit = newUserCompany.getCompanyNit();};
        if(userObtained.getCompanyEmail().equals(newUserCompany.getCompanyEmail()) == false ){ companyEmail = newUserCompany.getCompanyEmail();};
        if(userObtained.getCompanyName().equals(newUserCompany.getCompanyName()) == false ){ companyName = newUserCompany.getCompanyName();};

        flagCompany = this.gateway.existsByCompanyNitOrCompanyEmailOrCompanyName(companyNit, companyEmail, companyName);
        
        if(flagCompany){
            return false;
        }

        return true;
    }

}
