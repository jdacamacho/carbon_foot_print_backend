package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.Date;
import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageUserCompanyCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

public class ManageUserCompanyCUImplAdapter implements ManageUserCompanyCUIntPort {
    private final ManageUserCompanyGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    public ManageUserCompanyCUImplAdapter(ManageUserCompanyGatewayIntPort gateway, ExceptionFormatterIntPort errorFormatter){
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
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
        if(this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber()) != 0 &&
            this.gateway.existsCompanyByNit(userCompany.getCompanyNit()) != 0){
            this.errorFormatter.returnResponseErrorEntityExists("User already exists in the system");
        }
        userCompany.setRegistrationDate(new Date());
        System.out.println("Aquiii" + userCompany.getRegistrationDate());
        userResponse = this.gateway.save(userCompany);
        System.out.println("Aquiii" + userResponse.getRegistrationDate());
        return userResponse;
    }

    @Override
    public UserCompany updateUserCompany(long numberDocument, UserCompany userCompany) {
        UserCompany userResponse = null;
        if(this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber()) == 0 &&
            this.gateway.existsCompanyByNit(userCompany.getCompanyNit()) == 0){
            this.errorFormatter.returnResponseErrorEntityNotFound("User not found in the system");
        }
        userResponse = this.gateway.save(userCompany);
        return userResponse;
    }

    @Override
    public UserCompany getUserCompanyByNumberDocument(long numberDocument) {
        UserCompany userResponse = null;
        if(this.gateway.existsUserCompanyByNumberDocument(numberDocument) == 0){
            this.errorFormatter.returnResponseErrorEntityNotFound("User not found in the system");
        }
        userResponse = this.gateway.findUserCompanyByNumberDocument(numberDocument);
        return userResponse;
    }

    @Override
    public UserCompany getUserCompanyByNit(long nitCompany) {
        UserCompany userResponse = null;
        if(this.gateway.existsCompanyByNit(nitCompany) == 0){
            this.errorFormatter.returnResponseErrorEntityNotFound("User not found in the system");
        }
        userResponse = this.gateway.findCompanyByNit(nitCompany);
        return userResponse;
    }

}
