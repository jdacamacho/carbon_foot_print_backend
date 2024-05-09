package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PermissionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;

/**
 * Repositorio para la gestión de roles en la capa de persistencia.
 * 
 * Proporciona métodos para interactuar con los roles almacenados en la base de
 * datos.
 */
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

     /**
      * Verifica si existe un rol con el tipo de rol especificado.
      * 
      * @param typeRole El tipo de rol a verificar.
      * @return true si el rol fue encontrado, false en caso contrario.
      */
     boolean existsByTypeRole(String typeRole);

     /**
      * Obtiene una lista de todos los permisos disponibles.
      * 
      * @return La lista de permisos disponibles.
      */
     @Query("from PermissionEntity")
     List<PermissionEntity> findAllPermissions();

}
