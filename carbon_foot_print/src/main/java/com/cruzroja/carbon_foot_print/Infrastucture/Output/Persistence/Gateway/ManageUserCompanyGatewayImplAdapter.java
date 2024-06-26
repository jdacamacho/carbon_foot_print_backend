package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.UserCompanyRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.UserRepository;

@Service
public class ManageUserCompanyGatewayImplAdapter implements ManageUserCompanyGatewayIntPort{

    private final UserCompanyRepository serviceBDCompany;
    private final UserRepository serviceBDUser;
    private final ModelMapper mapper;

    public ManageUserCompanyGatewayImplAdapter(UserCompanyRepository serviceBDCompany, UserRepository serviceBDUser, ModelMapper mapper){
        this.serviceBDCompany = serviceBDCompany;
        this.serviceBDUser = serviceBDUser;
        this.mapper = mapper;
    }

    @Override
    public List<UserCompany> findAll() {
        Iterable<UserCompanyEntity> dataFromBD = this.serviceBDCompany.findAll();
        List<UserCompany> response = this.mapper.map(dataFromBD, new TypeToken<List<UserCompany>>(){}.getType());
        return response;
    }

    @Override
    public UserCompany save(UserCompany userCompany) {
        UserCompanyEntity userToSave = this.mapper.map(userCompany, UserCompanyEntity.class);
        UserCompanyEntity userSaved = this.serviceBDCompany.save(userToSave);
        UserCompany response = this.mapper.map(userSaved, UserCompany.class);
        return response;
    }

    @Override
    public UserCompany findUserCompanyByNumberDocument(long numberDocument) {
        UserCompanyEntity dataFromBD = this.serviceBDCompany.findById(numberDocument).get();
        UserCompany response = this.mapper.map(dataFromBD, UserCompany.class);
        return response;
    }

    @Override
    public boolean existsUserCompanyByNumberDocument(long numberDocument) {
        return this.serviceBDCompany.existsById(numberDocument);
    }

    @Override
    public boolean existsByCompanyNitOrCompanyEmailOrCompanyName(long nitCompany, String companyEmail, String companyName) {
        return this.serviceBDCompany.existsByCompanyNitOrCompanyEmailOrCompanyName(nitCompany, companyEmail, companyName);
    }

    @Override
    public boolean existsCompanyByNit(long nitCompany) {
        return this.serviceBDCompany.existsByCompanyNit(nitCompany);
    }

    @Override
    public UserCompany findByCompanyNit(long nitCompany) {
        UserCompanyEntity dataFromBD = this.serviceBDCompany.findByCompanyNit(nitCompany);
        UserCompany response = this.mapper.map(dataFromBD, UserCompany.class);
        return response;
    }

    @Override
    public List<Role> findAllRoles() {
        Iterable<RoleEntity> dataFromBD = this.serviceBDCompany.findAllRoles();
        List<Role> response = this.mapper.map(dataFromBD, new TypeToken<List<Role>>(){}.getType());
        return response;
    }

    @Override
    public boolean existByUsername(String username) {
        return this.serviceBDUser.existsByUsername(username);
    }

    @Override
    public boolean existsByPersonalEmail(String personalEmail) {
        return this.serviceBDUser.existsByPersonalEmail(personalEmail);
    }

    @Override
    public boolean existsByNit(long nit) {
        return this.serviceBDCompany.existsByCompanyNit(nit);
    }

    @Override
    public boolean existsByCompanyEmail(String companyEmail) {
        return this.serviceBDCompany.existsByCompanyEmail(companyEmail);
    }

    @Override
    public boolean existsByCompanyName(String companyEmail) {
        return this.serviceBDCompany.existsByCompanyName(companyEmail);
    }
    
}
