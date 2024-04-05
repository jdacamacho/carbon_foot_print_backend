package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageUserCompanyGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public UserCompany save(UserCompany userCompany) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public UserCompany update(long numberDocument, UserCompany userCompany) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public UserCompany findUserCompanyByNumberDocument(long numberDocument) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserCompanyByNumberDocument'");
    }

    @Override
    public long existsUserCompanyByNumberDocument(long numberDocument) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsUserCompanyByNumberDocument'");
    }

    @Override
    public UserCompany findCompanyByNit(long nitCompany) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCompanyByNit'");
    }

    @Override
    public long existsCompanyByNit(long nitCompany) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsCompanyByNit'");
    }

    
    
}
