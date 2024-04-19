package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

/**
 * Conexión con el módulo de persistencia.
 */
public interface ManageUserCompanyGatewayIntPort {

    public List<UserCompany> findAll();

    public UserCompany save(UserCompany userCompany);

    public UserCompany findUserCompanyByNumberDocument(long numberDocument);

    public boolean existsUserCompanyByNumberDocument(long numberDocument);

    public boolean existsByCompanyNitOrCompanyEmailOrCompanyName(long nitCompany, String companyEmail,
            String companyName);

    public boolean existsCompanyByNit(long nitCompany);

    public UserCompany findByCompanyNit(long nitCompany);

    public boolean existUserByDocumentNumberOrUsernameOrPersonalEmail(long numberDocument, String username,
            String email);

    public List<Role> findAllRoles();
}
