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

#PERMISOS PARA FUENTES
INSERT INTO permissions(idPermission, name, description) VALUES (500, "ROLE_Listar_Fuentes","Permiso para consultar todos las fuente en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (501, "ROLE_Crear_Fuente","Permiso para crear fuentes en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (502, "ROLE_Actualizar_Fuente","Permiso para actualizar las fuentes en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (503, "ROLE_Consultar_Fuente_ID","Permiso para consultar una fuente por ID");
INSERT INTO permissions(idPermission, name, description) VALUES (504, "ROLE_Consultar_Fuente_name","Permiso para consultar una fuente por nombre");


#PROBAR USUARIO PARA roles
INSERT INTO USERS(documentNumber, documentType, names, lastNames, personalPhone, state, personalEmail, username, password) 
VALUES(1000000001, "cedula", "UsuarioFuentes", "Prueba", 3140000001, 1, "userfuentes@gmail.com", "UserFuentes", "$2a$10$JmBzt5AQPL2YuO3aI6WaqO4Tp0wBeinBlzQgF3FA8tGM7wd1Dzhku");
INSERT INTO USER_ROLES(id_role, user_document_number) VALUES(2, 1000000001);
