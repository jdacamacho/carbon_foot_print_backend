package com.cruzroja.carbon_foot_print.Application.Input;

import com.cruzroja.carbon_foot_print.Domain.Models.Credential;

/**
 * Interfaz que define las operaciones para la gestión de autenticación de usuarios.
 */
public interface ManageAuthCUIntPort {

    /**
     * Realiza el inicio de sesión de un usuario.
     *
     * Este método permite autenticar a un usuario utilizando su nombre de usuario y contraseña.
     *
     * @param username El nombre de usuario del usuario que intenta iniciar sesión.
     * @param password La contraseña del usuario que intenta iniciar sesión.
     * @return La credencial del usuario autenticado si las credenciales son válidas,
     *         o un objeto de tipo Error si ocurre un fallo durante la autenticación.
     */
    public Credential login(String username, String password);
}
