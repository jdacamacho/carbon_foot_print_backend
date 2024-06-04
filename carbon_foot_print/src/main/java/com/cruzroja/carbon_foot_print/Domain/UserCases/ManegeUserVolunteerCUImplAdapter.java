/**
 * @file ManegeUserVolunteerCUImplAdapter.java
 * @brief Implementación de los casos de uso para la gestión de voluntarios.
 */

package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.cruzroja.carbon_foot_print.Application.Input.ManegeUserVolunteerCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManegeUserVolunteerGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

/**
 * @class ManegeUserVolunteerCUImplAdapter
 * @brief Implementación de los casos de uso para la gestión de voluntarios.
 * 
 * Esta clase implementa la interfaz ManegeUserVolunteerCUIntPort y proporciona
 * métodos para crear, actualizar, recuperar y gestionar voluntarios.
 */

public class ManegeUserVolunteerCUImplAdapter implements ManegeUserVolunteerCUIntPort {

    /** @brief Gateway para la gestión de voluntarios. */
    private final ManegeUserVolunteerGatewayIntPort gateway;

    /** @brief Formateador de excepciones. */
    private final ExceptionFormatterIntPort errorFormatter;

    /** @brief Codificador de contraseñas. */
    private final PasswordEncoder passwordEncoder;

    /**
     * @brief Constructor de la clase.
     * 
     * @param gateway Gateway para la gestión de voluntarios.
     * @param errorFormatter Formateador de excepciones.
     * @param passwordEncoder Codificador de contraseñas.
     */
    
    public ManegeUserVolunteerCUImplAdapter(ManegeUserVolunteerGatewayIntPort gateway,
            ExceptionFormatterIntPort errorFormatter,
            PasswordEncoder passwordEncoder) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @brief Recupera todos los voluntarios.
     * 
     * Este método devuelve una lista de todos los voluntarios registrados en el sistema.
     * 
     * @return Una lista de objetos de tipo UserVolunteer.
     * @throws NoDataException Si no se encuentran voluntarios.
     */
    @Override
    public List<UserVolunteer> listUserVolunteers() {
        List<UserVolunteer> volunteers = this.gateway.findAll();
        if (volunteers.size() == 0)
            this.errorFormatter.returNoData("No registered volunteers found");
        return volunteers;
    }

    /**
     * @brief Guarda un nuevo voluntario.
     * 
     * Este método guarda un nuevo voluntario en el sistema.
     * 
     * @param userVolunteer Objeto de tipo UserVolunteer con la información del voluntario.
     * @return Objeto de tipo UserVolunteer con la información del voluntario guardado.
     * @throws EntityExistsException Si ya existe un voluntario con el número de documento o el nombre de usuario o el correo personal.
     * @throws BadFormatEntityException Si los roles no son válidos.
     */
    @Override
    public UserVolunteer saveUserVolunteer(UserVolunteer userVolunteer) {
        if (this.gateway.existsById(userVolunteer.getDocumentNumber()))
            this.errorFormatter.returnResponseErrorEntityExists(
                    "All ready exist a user with number of document " + userVolunteer.getDocumentNumber() + ".");
        if (this.gateway.existsByUsername(userVolunteer.getUsername()))
            this.errorFormatter.returnResponseErrorEntityExists(
                    "All ready exist a user with username " + userVolunteer.getUsername() + ".");
        if (this.gateway.existsByPersonalEmail(userVolunteer.getPersonalEmail()))
            this.errorFormatter.returnResponseErrorEntityExists(
                    "All ready exist a user with personal email " + userVolunteer.getPersonalEmail() + ".");
        if (!userVolunteer.isValidRoles(this.gateway.findRoles()))
            this.errorFormatter.returnResponseBadFormat("The roles is not avalible.");

        String newPassword = this.passwordEncoder.encode(userVolunteer.getPassword());
        userVolunteer.setPassword(newPassword);
        return this.gateway.save(userVolunteer);
    }

    /**
     * @brief Actualiza un voluntario.
     * 
     * Este método actualiza un voluntario en el sistema.
     * 
     * @param userVolunteer Objeto de tipo UserVolunteer con la información actualizada del voluntario.
     * @return Objeto de tipo UserVolunteer con la información del voluntario actualizado.
     * @throws EntityNotFoundException Si no se encuentra el voluntario.
     * @throws EntityExistsException Si ya existe un voluntario con el nombre de usuario o el correo personal.
     * @throws BadFormatEntityException Si los roles no son válidos.
     */
    @Override
    public UserVolunteer updateUserVolunteer(UserVolunteer userVolunteer) {

        if (!this.gateway.existsById(userVolunteer.getDocumentNumber()))
            this.errorFormatter.returnResponseErrorEntityNotFound(
                    "The volunteer with document number " + userVolunteer.getDocumentNumber() + " has not been found.");
        UserVolunteer oldVolunteer = this.gateway.findUserVolunteerByNumberDocument(userVolunteer.getDocumentNumber());
        if (!oldVolunteer.verifyUsername(userVolunteer.getUsername()))
            if (this.gateway.existsByUsername(userVolunteer.getUsername()))
                this.errorFormatter.returnResponseErrorEntityExists(
                        "All ready exist an user with username " + userVolunteer.getUsername() + ".");
        if (!oldVolunteer.verifyPersonalEmail(userVolunteer.getPersonalEmail()))
            if (this.gateway.existsByPersonalEmail(userVolunteer.getPersonalEmail()))
                this.errorFormatter.returnResponseErrorEntityExists(
                        "All ready exist an user with personal email " + userVolunteer.getPersonalEmail() + ".");
        if (!userVolunteer.isValidRoles(this.gateway.findRoles()))
            this.errorFormatter.returnResponseBadFormat("The roles is not avalible.");
        oldVolunteer.update(userVolunteer);
        return this.gateway.save(oldVolunteer);
    }

    /**
     * @brief Elimina un voluntario.
     * 
     * Este método elimina un voluntario del sistema.
     * 
     * @param numberDocument Número de documento del voluntario a eliminar.
     * @throws EntityNotFoundException Si no se encuentra el voluntario.
     */
    @Override
    public UserVolunteer getUserVolunteerByNumberDocument(long numberDocument) {
        UserVolunteer volunteer = this.gateway.findUserVolunteerByNumberDocument(numberDocument);
        if (volunteer == null)
            this.errorFormatter.returnResponseErrorEntityNotFound(
                    "The volunteer with document number " + numberDocument + " has not been found.");
        return volunteer;
    }

    /**
     * @brief Recupera un voluntario por número de documento.
     * 
     * Este método recupera un voluntario por su número de documento.
     * 
     * @param numberDocument Número de documento del voluntario a recuperar.
     * @return Objeto de tipo UserVolunteer con la información del voluntario.
     * @throws EntityNotFoundException Si no se encuentra el voluntario.
     */
    @Override
    public List<UserVolunteer> getUserVolunteerByPosition(String position) {
        List<UserVolunteer> volunteers = this.gateway.findUserVolunteerByPosition(position);
        if (volunteers.size() == 0)
            this.errorFormatter.returNoData("There are no volunteers registered with the position: " + position + ".");
        return volunteers;
    }

    /**
     * @brief Recupera un voluntario por número de documento.
     * 
     * Este método recupera un voluntario por su número de documento.
     * 
     * @param numberDocument Número de documento del voluntario a recuperar.
     * @return Objeto de tipo UserVolunteer con la información del voluntario.
     * @throws EntityNotFoundException Si no se encuentra el voluntario.
     */
    @Override
    public double detectCarbonFootprint(UserVolunteer userVolunteer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'detectCarbonFootprint'");
    }

    /**
     * @brief Recupera un voluntario por número de documento.
     * 
     * Este método recupera un voluntario por su número de documento.
     * 
     * @param numberDocument Número de documento del voluntario a recuperar.
     * @return Objeto de tipo UserVolunteer con la información del voluntario.
     * @throws EntityNotFoundException Si no se encuentra el voluntario.
     */
    @Override
    public boolean updateCarbonCompensationProgress(UserVolunteer userVolunteer, double progress) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCarbonCompensationProgress'");
    }

}
