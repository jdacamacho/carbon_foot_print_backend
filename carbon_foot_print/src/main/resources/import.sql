##Creo un rol que permita acciones sobre los roles
INSERT INTO ROLES(idRole,typeRole,state) VALUES(1,"AdministradorPrueba",1);

#Le aaigno permisos al ROL
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(100,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(101,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(102,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(103,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(104,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(105,1);

##Creo un usuario administrador que sera un voluntario
##La contraseña es AdminHuellaCarbonoJDCE1002
INSERT INTO USERS(documentNumber,documentType,names,lastNames,personalPhone,state,personalEmail,username,password) VALUES(1000000000,"cedula","ADMIN","ADMIN",3147242572,1,"admin@gmail.com","ADMIN","$2a$10$JmBzt5AQPL2YuO3aI6WaqO4Tp0wBeinBlzQgF3FA8tGM7wd1Dzhku");
INSERT INTO VOLUNTEERS(documentNumber,position) VALUES (1000000000,"Admin del sistema");

##Le asigno el rol al usuario administrador creado
INSERT INTO USER_ROLES(id_role,user_document_number) VALUES(1,1000000000);

#PERMISOS PARA ROLES
INSERT INTO permissions(idPermission, name, description) VALUES (100, "ROLE_Listar_Roles","Permiso para consultar todos los roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (101, "ROLE_Crear_Roles","Permiso para crear roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (102, "ROLE_Actualizar_Roles","Permiso para actualizar los roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (103, "ROLE_Consultar_Rol","Permiso para consultar un rol en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (104, "ROLE_Listar_permisos","Permiso para listar permisos");

#PERMISOS PARA VOLUNTARIOS
INSERT INTO permissions(idPermission, name, description) VALUES (200, "ROLE_Listar_Voluntarios","Permiso para consultar todos los voluntarios en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (201, "ROLE_Crear_Voluntarios","Permiso para crear voluntarios en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (202, "ROLE_Actualizar_Voluntarios","Permiso para actualizar los voluntarios en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (203, "ROLE_Consultar_Voluntario","Permiso para consultar un voluntario en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (204, "ROLE_Consultar_Voluntario_Posicion","Permiso para consultar un voluntario por posicion en el sistema");

#PERMISOS PARA EMPRESAS
INSERT INTO permissions(idPermission, name, description) VALUES (300, "ROLE_Listar_Empresas","Permiso para consultar todos las empresas en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (301, "ROLE_Crear_Empresas","Permiso para crear empresas en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (302, "ROLE_Actualizar_Empresas","Permiso para actualizar las empresas en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (303, "ROLE_Consultar_Empresa_NIT","Permiso para consultar una empresa por NIT");
INSERT INTO permissions(idPermission, name, description) VALUES (304, "ROLE_Consultar_Empresa_Documento","Permiso para consultar una empresa por numero de documento");

#PERMISOS PARA CATEGORIAS
INSERT INTO permissions(idPermission, name, description) VALUES (400, "ROLE_Listar_Categorias","Permiso para consultar todos las categorías en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (401, "ROLE_Crear_Categoria","Permiso para crear categorías en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (402, "ROLE_Actualizar_Categoria","Permiso para actualizar las categorías en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (403, "ROLE_Consultar_Categoria_ID","Permiso para consultar una categoría por ID");

INSERT INTO permissions(idPermission, name, description) VALUES (404, "ROLE_Consultar_Categorias_IDs","Permiso para consultar varias categorías por ID");
INSERT INTO permissions(idPermission, name, description) VALUES (405, "ROLE_Consultar_Categoria_Name","Permiso para consultar una categoría por nombre");
INSERT INTO permissions(idPermission, name, description) VALUES (406, "ROLE_Consultar_Categorias_Habilitadas","Permiso para consultar todas las categorías habilitadas");
INSERT INTO permissions(idPermission, name, description) VALUES (407, "ROLE_Consultar_Categoria_Habilitadas_IDs","Permiso para consultar las categorías habilitadas de una lista de IDs");


#PERMISOS PARA FUENTES
INSERT INTO permissions(idPermission, name, description) VALUES (500, "ROLE_Listar_Fuentes","Permiso para consultar todos las fuente en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (501, "ROLE_Crear_Fuente","Permiso para crear fuentes en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (502, "ROLE_Actualizar_Fuente","Permiso para actualizar las fuentes en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (503, "ROLE_Consultar_Fuente_ID","Permiso para consultar una fuente por ID");
INSERT INTO permissions(idPermission, name, description) VALUES (504, "ROLE_Consultar_Fuente_name","Permiso para consultar una fuente por nombre");

#PERMISOS PARA CONTAMINANTES
INSERT INTO permissions(idPermission, name, description) VALUES (600, "ROLE_Listar_Contaminantes","Permiso para listar los contaminantes.");
INSERT INTO permissions(idPermission, name, description) VALUES (601, "ROLE_Crear_Contaminantes","Permiso para crear un contaminante.");
INSERT INTO permissions(idPermission, name, description) VALUES (602, "ROLE_Actualizar_Contaminantes","Permiso para actualizar un contaminante.");
INSERT INTO permissions(idPermission, name, description) VALUES (603, "ROLE_Consultar_Contaminante_ID","Permiso para consultar un contaminante por ID.");
INSERT INTO permissions(idPermission, name, description) VALUES (604, "ROLE_Consultar_Contaminante_Name","Permiso para consultar contaminantes por patrón de nombre.");

#PERMISOS PARA FUENTES CONTAMINANTES
INSERT INTO permissions(idPermission, name, description) VALUES (700, "ROLE_Listar_Fuente_Contaminante","Permiso para listar todas las fuentes contaminantes.");
INSERT INTO permissions(idPermission, name, description) VALUES (701, "ROLE_Consultar_Fuente_Contaminante_ID","Permiso para consultar una fuente contaminante por id.");
INSERT INTO permissions(idPermission, name, description) VALUES (702, "ROLE_Consultar_Fuentes_Contaminantes_IDs","Permiso para consultar varias fuentes contaminantes por lista de ids.");

#PERMISOS PARA ACCIONES
INSERT INTO permissions(idPermission, name, description) VALUES (800, "ROLE_Listar_Acciones","Permiso para listar los acciones.");
INSERT INTO permissions(idPermission, name, description) VALUES (801, "ROLE_Crear_Acciones","Permiso para crear una accion.");
INSERT INTO permissions(idPermission, name, description) VALUES (802, "ROLE_Actualizar_Acciones","Permiso para actualizar una accion.");
INSERT INTO permissions(idPermission, name, description) VALUES (803, "ROLE_Consultar_Accion_ID","Permiso para consultar una accion por ID.");
INSERT INTO permissions(idPermission, name, description) VALUES (804, "ROLE_Consultar_Accion_Name","Permiso para consultar una accion por nombre.");

#PERMISOS PARA PLANES DE ACCION
INSERT INTO permissions(idPermission, name, description) VALUES (900, "ROLE_Listar_Planes","Permiso para listar los planes.");
INSERT INTO permissions(idPermission, name, description) VALUES (901, "ROLE_Crear_Planes","Permiso para crear un plan.");
INSERT INTO permissions(idPermission, name, description) VALUES (902, "ROLE_Actualizar_Planes","Permiso para actualizar un plan.");
INSERT INTO permissions(idPermission, name, description) VALUES (903, "ROLE_Consultar_Plan_ID","Permiso para consultar un plan por ID.");
INSERT INTO permissions(idPermission, name, description) VALUES (904, "ROLE_Consultar_Plan_Name","Permiso para consultar un plan por nombre.");

#PERMISOS PARA COMPENSATION ACTIONS
INSERT INTO permissions(idPermission, name, description) VALUES (1000, "ROLE_Crear_plan_generico","Permiso para crear planes genéricos.");
INSERT INTO permissions(idPermission, name, description) VALUES (1001, "ROLE_Crear_plan_personalizado","Permiso para crear planes personalizados.");
INSERT INTO permissions(idPermission, name, description) VALUES (1002, "ROLE_Listar_planes_personalizados","Permiso para listar planes personalizados.");
INSERT INTO permissions(idPermission, name, description) VALUES (1003, "ROLE_Listar_planes_genericos","Permiso para listar planes genéricos.");
INSERT INTO permissions(idPermission, name, description) VALUES (1004, "ROLE_Actualizar_plan","Permiso para actualizar planes.");
INSERT INTO permissions(idPermission, name, description) VALUES (1005, "ROLE_Listar_planes","Permiso para listar todos los planes.");
INSERT INTO permissions(idPermission, name, description) VALUES (1006, "ROLE_Consultar_plan_id","Permiso consultar un plan por su Id.");


#PROBAR USUARIO PARA roles
INSERT INTO USERS(documentNumber, documentType, names, lastNames, personalPhone, state, personalEmail, username, password) 
VALUES(1000000001, "cedula", "UsuarioFuentes", "Prueba", 3140000001, 1, "userfuentes@gmail.com", "UserFuentes", "$2a$10$JmBzt5AQPL2YuO3aI6WaqO4Tp0wBeinBlzQgF3FA8tGM7wd1Dzhku");
INSERT INTO USER_ROLES(id_role, user_document_number) VALUES(2, 1000000001);

#Creo Rol para asignarle todos los permisos
INSERT INTO ROLES values (1,3,"AllPermisions");

#Asigno los permisos al rol
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (100,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (101,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (102,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (103,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (104,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (200,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (201,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (202,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (203,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (204,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (300,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (301,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (302,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (303,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (304,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (400,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (401,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (402,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (403,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (404,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (405,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (406,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (407,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (500,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (501,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (502,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (503,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (504,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (600,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (601,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (602,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (603,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (604,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (701,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (702,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (703,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (800,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (801,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (802,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (803,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (804,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (900,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (901,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (902,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (903,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (904,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1000,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1001,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1002,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1003,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1004,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1005,3);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES (1006,3);


# Asigno El rol a un usuario
INSERT INTO USER_ROLES(id_role,user_document_number) VALUES(3,1000000000);

## Triggers para tablas historicas
delimiter //
CREATE TRIGGER tgrUpdateHistoricarAction after update on actions
for each row
begin
update 
	historicalaction 
    set 
		histaricalActionCloseDate = CURDATE() 
	where 
    actionId = OLD.actionId and 
    histaricalActionCloseDate IS NULL;
insert into historicalaction(histaricalActionCloseDate,histaricalActionEffectiveDate,historicalActionDescription,historicalActionName,historicalActionUnitaryPrice,actionId)
values (null,curdate(),NEW.actionDescription, new.actionName, new.actionUnitaryPrice, new.actionId);
end//

delimiter ;

delimiter //
CREATE TRIGGER tgrInsertHistoricarAction after insert on actions
for each row
begin
insert into historicalaction(histaricalActionCloseDate,histaricalActionEffectiveDate,historicalActionDescription,historicalActionName,historicalActionUnitaryPrice,actionId)
values (null,curdate(),NEW.actionDescription, new.actionName, new.actionUnitaryPrice, new.actionId);
end//

delimiter ;