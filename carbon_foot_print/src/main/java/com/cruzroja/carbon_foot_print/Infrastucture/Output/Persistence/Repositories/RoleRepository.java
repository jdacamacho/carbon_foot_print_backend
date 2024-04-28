package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PermissionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    /**
     * Verifica si existe un rol con el tipo de rol especificado.
     * 
     * @param typeRole El tipo de rol a verificar.
     * @return {boolean} [true] si el rol fue encontrado, [false] en caso contrario.
     */
    boolean existsByTypeRole(String typeRole);

    @Query("from PermissionEntity")
    /**
     * Obtiene una lista de todos los permisos disponibles 
     * @return la lista de los permisos {List<PermissionEntity>}
     */
    List<PermissionEntity> findAllPermissions();

}
