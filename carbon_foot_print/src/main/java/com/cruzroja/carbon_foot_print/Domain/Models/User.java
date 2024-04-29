package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa un usuario en el sistema
 */
@Data
@AllArgsConstructor
public class User {
    
    /** Número de documento del usuario */
    private long documentNumber;
    
    /** Tipo de documento del usuario */
    private String documentType;
    
    /** Nombres del usuario */
    private String names;
    
    /** Apellidos del usuario */
    private String lastNames;
    
    /** Teléfono personal del usuario */
    private String personalPhone;
    
    /** Correo electrónico personal del usuario */
    private String personalEmail;
    
    /** Nombre de usuario del usuario */
    private String username;
    
    /** Contraseña del usuario */
    private String password;
    
    /** Lista de roles asociados al usuario */
    private List<Role> roles;
    
    /** Estado del usuario */
    private boolean state;

    /**
     * Constructor de la clase User. Inicializa la lista de roles.
     */
    public User() {
        this.roles = new ArrayList<>();
    }

    /**
     * Verifica si los roles del usuario son válidos.
     * 
     * @param validRoles Lista de roles válidos.
     * @return true si los roles del usuario son válidos, false de lo contrario.
     */
    public boolean isValidRoles(List<Role> validRoles) {
        List<Role> roles = this.getRoles();
        int wasFound = 0;
        for (Role role : roles) {
            for (Role roleValid : validRoles) {
                if (role.equals(roleValid))
                    wasFound++;
            }
        }
        return roles.size() == wasFound;
    }

    /**
     * Verifica si el usuario tiene roles duplicados.
     * 
     * @return true si el usuario tiene roles duplicados, false de lo contrario.
     */
    public boolean hasDuplicateRoles(){
        Set<Role> roleSet = new HashSet<>(this.getRoles());
        return roleSet.size() < this.getRoles().size();
    }

    /**
     * Actualiza los atributos del usuario.
     * 
     * @param user Usuario con los nuevos atributos.
     */
    protected void update(User user) {
        this.documentType = user.getDocumentType();
        this.names = user.getNames();
        this.lastNames = user.getLastNames();
        this.personalPhone = user.getPersonalPhone();
        this.personalEmail = user.getPersonalEmail();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.state = user.isState();
    }

    /**
     * Verifica si el nombre de usuario coincide con el proporcionado.
     * 
     * @param username Nombre de usuario a verificar.
     * @return true si el nombre de usuario coincide, false de lo contrario.
     */
    public boolean verifyUsername(String username) {
        return this.getUsername().equals(username);
    }

    /**
     * Verifica si el correo electrónico personal coincide con el proporcionado.
     * 
     * @param email Correo electrónico a verificar.
     * @return true si el correo electrónico coincide, false de lo contrario.
     */
    public boolean verifyPersonalEmail(String email) {
        return this.getPersonalEmail().equals(email);
    }
}
