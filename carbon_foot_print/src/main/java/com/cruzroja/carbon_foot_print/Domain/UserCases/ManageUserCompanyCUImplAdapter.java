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
        long nitCompany = 0;
        UserCompany userResponse = null;
        if(this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber()) != 0 &&
            this.gateway.existsCompanyByNit(userCompany.getCompanyNit()) != 0){
            this.errorFormatter.returnResponseErrorEntityExists("User duplicate");
        }
        userCompany.setRegistrationDate(new Date());
        userCompany.getAddress().setObjUserCompany(userCompany);
        nitCompany = userCompany.getCompanyNit();
        userCompany.getAddress().setCompanyNit(nitCompany);
        userResponse = this.gateway.save(userCompany);

        return userResponse;
    }

    @Override
    public UserCompany updateUserCompany( UserCompany userCompany) {
        UserCompany userResponse = null;
        if(this.gateway.existsUserCompanyByNumberDocument(userCompany.getDocumentNumber()) == 0 &&
            this.gateway.existsCompanyByNit(userCompany.getCompanyNit()) == 0){
            this.errorFormatter.returnResponseErrorEntityNotFound("User not found in the system");
        }
        UserCompany userGot = this.gateway.findUserCompanyByNumberDocument(userCompany.getDocumentNumber());

        userGot.setNames(userCompany.getNames());
        userGot.setLastNames(userCompany.getLastNames());
        userGot.setPersonalPhone(userCompany.getPersonalPhone());
        userGot.setPersonalEmail(userCompany.getPersonalEmail());
        userGot.setRoles(userCompany.getRoles());
        userGot.setState(userCompany.isState());
        userGot.setCompanyNit(userCompany.getCompanyNit());
        userGot.setCompanyName(userCompany.getCompanyName());
        userGot.setAddress(userCompany.getAddress());

        userResponse = this.gateway.save(userGot);

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
