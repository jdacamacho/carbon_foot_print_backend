package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.Optional;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;

public interface ManageAuthGatewayIntPort {
    
    public Optional<UserEntity> findByUsername(String username);

    /**
     * Verifica si existe un usuario con el nombre 
     * @param username El nombre de usuario 
     * @return {boolean} [true] si el nombre existe, [false] en caso contrario.
     */
    public boolean existByUsername(String username);
}
