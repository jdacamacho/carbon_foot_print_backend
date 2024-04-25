package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.Optional;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;

public interface ManageAuthGatewayIntPort {
    public Optional<UserEntity> findByUsername(String username);
    public boolean existByUsername(String username);
}
