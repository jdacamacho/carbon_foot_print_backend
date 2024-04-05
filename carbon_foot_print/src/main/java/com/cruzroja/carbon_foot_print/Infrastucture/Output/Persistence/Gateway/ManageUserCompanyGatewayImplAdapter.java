package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.UserCompanyRepository;

@Service
public class ManageUserCompanyGatewayImplAdapter implements ManageUserCompanyGatewayIntPort{

    private final UserCompanyRepository serviceBD;
    private final ModelMapper mapper;

    public ManageUserCompanyGatewayImplAdapter(UserCompanyRepository serviceBD, ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<UserCompany> findAll() {
        Iterable<UserCompanyEntity> dataFromBD = this.serviceBD.findAll();
        List<UserCompany> response = this.mapper.map(dataFromBD, new TypeToken<List<UserCompany>>(){}.getType());
        return response;
    }

    @Override
    public UserCompany save(UserCompany userCompany) {
        UserCompanyEntity userToSave = this.mapper.map(userCompany, UserCompanyEntity.class);
        UserCompanyEntity userSaved = this.serviceBD.save(userToSave);
        UserCompany response = this.mapper.map(userSaved, UserCompany.class);
        return response;
    }

    @Override
    public UserCompany findUserCompanyByNumberDocument(long numberDocument) {
        UserCompanyEntity dataFromBD = this.serviceBD.findById(numberDocument).get();
        UserCompany response = this.mapper.map(dataFromBD, UserCompany.class);
        return response;
    }

    @Override
    public long existsUserCompanyByNumberDocument(long numberDocument) {
        return this.serviceBD.countByUserCompanyNumberDocument(numberDocument);
    }

    @Override
    public UserCompany findCompanyByNit(long nitCompany) {
        UserCompanyEntity dataFromBD = this.serviceBD.findByCompanyNit(nitCompany);
        UserCompany response = this.mapper.map(dataFromBD, UserCompany.class);
        return response;
    }

    @Override
    public long existsCompanyByNit(long nitCompany) {
        return this.serviceBD.countByCompanyNit(nitCompany);
    }
    
}
