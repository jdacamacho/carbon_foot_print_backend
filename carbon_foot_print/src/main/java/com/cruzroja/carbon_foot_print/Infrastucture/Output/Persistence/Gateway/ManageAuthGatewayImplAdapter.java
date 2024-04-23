package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageAuthGatewayIntPort;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.UserRepository;

@Service
public class ManageAuthGatewayImplAdapter implements ManageAuthGatewayIntPort {
    
    private final UserRepository serviceBD;

    public ManageAuthGatewayImplAdapter(UserRepository serviceBD){
        this.serviceBD = serviceBD;
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return this.serviceBD.findByUsername(username);
    }

    @Override
    public boolean existByUsername(String username) {
        if(this.serviceBD.countByUsername(username) == 0){
            return false;
        }
        return true;
    }

    
    
}
