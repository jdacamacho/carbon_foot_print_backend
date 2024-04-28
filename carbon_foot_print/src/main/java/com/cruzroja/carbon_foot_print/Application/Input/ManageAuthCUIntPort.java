package com.cruzroja.carbon_foot_print.Application.Input;

import com.cruzroja.carbon_foot_print.Domain.Models.Credential;

public interface ManageAuthCUIntPort {

    /**
     * Reglas de negocio para el inicio de sesión.
     * @param username Nombre de usuario {String}.
     * @param password Contraseña {String}.
     * @return Credencial del usuario autenticado {Credential} o {Error} en caso de fallo.
     */
    public Credential login(String username, String password);
}
