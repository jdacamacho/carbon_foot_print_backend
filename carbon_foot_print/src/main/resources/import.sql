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