package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

public interface ManegeUserVolunteerCUIntPort {
    /**
     * Reglas de negocio para listar los voluntarios.
     * 
     * @return {List<UserVolunteer>} lista de usuarios o {Error} fallo de reglas de
     *         negocios.
     */
    public List<UserVolunteer> listUserVolunteers();

    /**
     * Reglas de negocio para guardar un voluntario.
     * 
     * @param userVolunteer {UserVolunteer} Información del usuario voluntario.
     * @return {UserVolunteer} Información del usuario guardado o {Error} fallo de
     *         reglas de negocios.
     */
    public UserVolunteer saveUserVolunteer(UserVolunteer userVolunteer);

    /**
     * Reglas de negocio para actualizar el voluntario.
     * 
     * @param userVolunteer {UserVolunter} Información nueva del voluntario.
     * @return {UserVolunteer} instancia guardada en la base de datos o {Error}
     *         fallo de reglas de negocios.
     */
    public UserVolunteer updateUserVolunteer(UserVolunteer userVolunteer);

    /**
     * Reglas de negocio para consultar un único voluntario por el número de
     * documento.
     * 
     * @param numberDocument {long} número de documento del usuario.
     * @return {UserVolunteer} Usuario recuperado o {Error} fallo de reglas de
     *         negocios.
     */
    public UserVolunteer getUserVolunteerByNumberDocument(long numberDocument);

    /**
     * Reglas de negocio para listar usuarios de una posición específica.
     * 
     * @param position {String} Posición a consultar
     * @return {List<UserVolunteer>} Lista de usuarios o {Error} fallo de reglas de
     *         negocios.
     */
    public List<UserVolunteer> getUserVolunteerByPosition(String position);

    /**
     * Reglas de negocio para detectar la huella de carbono de un usuario voluntario.
     * 
     * @param userVolunteer {UserVolunteer} Información del usuario voluntario.
     * @return {double} Valor de la huella de carbono detectada o {Error} fallo de
     *         reglas de negocios.
     */
    public double detectCarbonFootprint(UserVolunteer userVolunteer);

    /**
     * Reglas de negocio para actualizar el progreso del plan de compensación de la huella de carbono.
     * 
     * @param userVolunteer {UserVolunteer} Información del usuario voluntario.
     * @param progress {double} Progreso del plan de compensación.
     * @return {boolean} True si se actualiza correctamente, False si hay un fallo.
     */
    public boolean updateCarbonCompensationProgress(UserVolunteer userVolunteer, double progress);
}
