package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.Optional;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;

/**
 * Esta interfaz proporciona métodos para gestionar la autenticación de usuarios en la aplicación.
 */
public interface ManageAuthGatewayIntPort {
    
    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return Un objeto Optional que puede contener el usuario correspondiente, si se encuentra.
     */
    public Optional<UserEntity> findByUsername(String username);

    /**
     * Verifica si existe un usuario con el nombre de usuario especificado.
     *
     * @param username El nombre de usuario a verificar.
     * @return [true] si existe un usuario con el nombre de usuario especificado, [false] en caso contrario.
     */
    public boolean existByUsername(String username);
}
