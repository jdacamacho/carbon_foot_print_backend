package com.cruzroja.carbon_foot_print.Application.Output;

/**
 * Esta interfaz define los métodos para formatear y manejar excepciones y mensajes de error
 * relacionados con la huella de carbono.
 */
public interface ExceptionFormatterIntPort {

    /**
     * Método para devolver un mensaje de error cuando ya existe una entidad.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returnResponseErrorEntityExists(String message);

    /**
     * Método para devolver un mensaje de error cuando no se encuentra una entidad.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returnResponseErrorEntityNotFound(String message);

    /**
     * Método para devolver un mensaje de error cuando se viola una regla de negocio.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returnResponseBusinessRuleViolated(String message);

    /**
     * Método para devolver un mensaje de error de credenciales no válidas.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returnResponseBadCredentials(String message);

    /**
     * Método para devolver un mensaje de error de formato incorrecto.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returnResponseBadFormat(String message);

    /**
     * Método para devolver un mensaje de error cuando no hay datos disponibles.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returNoData(String message);

    /**
     * Método para devolver un mensaje de error cuando no se tiene acceso.
     *
     * @param message Mensaje descriptivo del error.
     */
    public void returNoAccess(String message);
}
