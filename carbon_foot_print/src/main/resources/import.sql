#ROL ADMINISTRADOR
INSERT INTO ROLES(idRole,typeRole,state) VALUES(1,"Administrador",1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(100,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(101,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(102,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(103,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(104,1);
INSERT INTO ROLE_PERMISSIONS(idPermission,idRole) VALUES(105,1);

#USUARIO ADMINISTRADOR
#CONTRASEÑA = AdminHuellaCarbonoJDCE1002
INSERT INTO USERS(documentNumber,documentType,names,lastNames,personalPhone,state,personalEmail,username,password) VALUES(1000000000,"cedula","ADMIN","ADMIN",3147242572,1,"admin@gmail.com","ADMIN","$2a$10$JmBzt5AQPL2YuO3aI6WaqO4Tp0wBeinBlzQgF3FA8tGM7wd1Dzhku");
INSERT INTO VOLUNTEERS(documentNumber,position) VALUES (1000000000,"Admin del sistema");
INSERT INTO USER_ROLES(id_role,user_document_number) VALUES(1,1000000000);

#PERMISOS PARA ROLES
INSERT INTO permissions(idPermission, name, description) VALUES (100, "ROLE_Listar_Roles","Permiso para consultar todos los roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (101, "ROLE_Crear_Roles","Permiso para crear roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (102, "ROLE_Actualizar_Roles","Permiso para actualizar los roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (103, "ROLE_Eliminar_Roles","Permiso para eliminar los roles en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (104, "ROLE_Consultar_Rol","Permiso para consultar un rol en el sistema");
INSERT INTO permissions(idPermission, name, description) VALUES (105, "ROLE_Listar_permisos","Permiso para listar permisos");

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