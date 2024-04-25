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

        if(this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber()) ){
            this.errorFormatter.returnResponseErrorEntityExists("User duplicate already exists with that number document");
        }else if(this.gateway.existByUsername(userCompany.getUsername())){
            this.errorFormatter.returnResponseErrorEntityExists("User duplicate already exists with that username");
        }else if(this.gateway.existsByPersonalEmail(userCompany.getPersonalEmail())){
            this.errorFormatter.returnResponseErrorEntityExists("User duplicate already exists with that personal email");
        }else{
            if(this.gateway.existsCompanyByNit(userCompany.getCompanyNit())){
                this.errorFormatter.returnResponseErrorEntityExists("Company duplicate already exists with that company nit");
            }else if(this.gateway.existsByCompanyName(userCompany.getCompanyName())){
                this.errorFormatter.returnResponseErrorEntityExists("Company duplicate already exists with that company name");
            }else if(this.gateway.existsByCompanyEmail(userCompany.getCompanyEmail())){
                this.errorFormatter.returnResponseErrorEntityExists("Company duplicate already exists with that company email");
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
        }
       
        return userResponse;
    }

    @Override
    public UserCompany updateUserCompany( UserCompany userCompany) {
        UserCompany userResponse = null;

        if(!this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber())){
            this.errorFormatter.returnResponseErrorEntityNotFound("Company not found with that document number");
        }else{
            if(!userCompany.isValidRoles(this.gateway.findAllRoles())){
                this.errorFormatter.returnResponseBusinessRuleViolated("Roles are not valid");
            }else if(userCompany.hasDuplicateRoles()){
                this.errorFormatter.returnResponseBusinessRuleViolated("User has roles duplicates");
            }else{
                UserCompany userObtained = this.gateway.findUserCompanyByNumberDocument(userCompany.getDocumentNumber());
                
                if(this.gateway.existByUsername(userCompany.getUsername())){
                    if(!userObtained.verifyUsername(userCompany.getUsername())){
                        this.errorFormatter.returnResponseErrorEntityExists("Error already exists a user with this Username");
                    }
                }
                if(this.gateway.existsByPersonalEmail(userCompany.getPersonalEmail())){
                    if(!userObtained.verifyPersonalEmail(userCompany.getPersonalEmail())){
                        this.errorFormatter.returnResponseErrorEntityExists("Error already exists a user with this personal email");
                    }
                }
                if(this.gateway.existsCompanyByNit(userCompany.getCompanyNit())){
                    if(!userObtained.verifyNit(userCompany.getCompanyNit())){
                        this.errorFormatter.returnResponseErrorEntityExists("Error already exists a company with this Nit");
                    }
                }
                if(this.gateway.existsByCompanyName(userCompany.getCompanyName())){
                    if(!userObtained.verifyCompanyName(userCompany.getCompanyName())){
                        this.errorFormatter.returnResponseErrorEntityExists("Error already exists a company with this name");
                    }
                }
                if(this.gateway.existsByCompanyEmail(userCompany.getCompanyEmail())){
                    if(!userObtained.verifyCompanyEmail(userCompany.getCompanyEmail())){
                        this.errorFormatter.returnResponseErrorEntityExists("Error already exists a company with this email");
                    }
                }

                userObtained.update(userCompany);
                userResponse = this.gateway.save(userObtained);
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

}
