package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

public interface ManageUserCompanyCUIntPort {
    public List<UserCompany> listUserCompany();
    public UserCompany saveUserCompany(UserCompany userCompany);
    public UserCompany updateUserCompany(long numberDocument,UserCompany userCompany);
    public UserCompany getUserCompanyByNumberDocument(long numberDocument);
    public UserCompany getUserCompanyByNit(long nitCompany);

}
