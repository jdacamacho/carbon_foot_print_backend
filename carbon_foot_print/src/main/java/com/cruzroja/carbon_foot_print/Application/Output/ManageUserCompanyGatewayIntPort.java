package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

public interface ManageUserCompanyGatewayIntPort {
    public List<UserCompany> findAll();
    public UserCompany save(UserCompany userCompany);
    public UserCompany findUserCompanyByNumberDocument(long numberDocument);
    public boolean existsUserCompanyByNumberDocument(long numberDocument);
    public UserCompany findByCompanyNitOrCompanyEmailOrCompanyName(long nitCompany, String companyEmail, String companyName);
    public boolean existsCompanyByNit(long nitCompany);   
}
