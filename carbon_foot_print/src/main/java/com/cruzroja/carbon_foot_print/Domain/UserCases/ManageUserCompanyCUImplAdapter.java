package com.cruzroja.carbon_foot_print.Domain.UserCases;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUserCompany'");
    }

    @Override
    public UserCompany updateUserCompany(long numberDocument, UserCompany userCompany) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserCompany'");
    }

    @Override
    public UserCompany getUserCompanyByNumberDocument(long numberDocument) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserCompanyByNumberDocument'");
    }

    @Override
    public UserCompany getUserCompanyByNit(long nitCompany) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserCompanyByNit'");
    }

    
}
