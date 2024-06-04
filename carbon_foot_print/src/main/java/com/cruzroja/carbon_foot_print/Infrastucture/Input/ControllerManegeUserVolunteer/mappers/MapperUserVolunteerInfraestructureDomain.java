/**
 * @file MapperUserVolunteerInfraestructureDomain.java
 * @brief Mapeador entre la capa de infraestructura y la de dominio.
 */
package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest.UserVolunteerDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTOResponse.UserVolunteerDTOResponse;

/** @class MapperUserVolunteerInfraestructureDomain
 *  @brief Mapeador entre la capa de infraestructura y la de dominio.
 * 
 *  Esta clase implementa un mapeador entre la capa de infraestructura y la de dominio.
 */
@Mapper(componentModel = "spring")
public interface MapperUserVolunteerInfraestructureDomain {

    /**
     * @brief Mapea un objeto de petición a un modelo.
     * 
     * @param request Objeto de petición.
     * @return Modelo.
     */
    UserVolunteer mapRequestModel(UserVolunteerDTORequest request);
    
    /**
     * @brief Mapea un modelo a un objeto de respuesta.
     * 
     * @param model Modelo.
     * @return Objeto de respuesta.
     */
    
    UserVolunteerDTOResponse mapModelToResponse(UserVolunteer model);

    /**
     * @brief Mapea una lista de modelos a una lista de objetos de respuesta.
     * 
     * @param volunteers Lista de modelos.
     * @return Lista de objetos de respuesta.
     */
    
    List<UserVolunteerDTOResponse> mapModelsToResponse(List<UserVolunteer> volunteers);
}
