CREATE TABLE user (
  id varchar(36) NOT NULL,
  email varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  username varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX user_by_id ON proentel_security.user(id);
insert into user (id,email,name,username,password,isactive,create_by,update_by)
 values('37c25797-863b-11ed-ad13-f8a2d67e42de','admin@admin.com','administrador','admin', 'admin12345','1','admin','admin');


CREATE TABLE rol (
  id varchar(36) NOT NULL,
  name varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX rol_by_id ON proentel_security.rol(id);
insert into rol (id,name,isactive,create_by,update_by)
 values('37ca9ac4-863b-11ed-ad13-f8a2d67e42de', 'ROL_ADMIN','1','admin','admin');

CREATE TABLE user_rol (
  id varchar(36) NOT NULL,
  user_id varchar(36) DEFAULT NULL,
  rol_id varchar(36) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX user_rol_by_id ON proentel_security.user_rol(id);
insert into user_rol (id,user_id,rol_id,isactive,create_by,update_by) values (UUID(),'37c25797-863b-11ed-ad13-f8a2d67e42de','37ca9ac4-863b-11ed-ad13-f8a2d67e42de', '1','admin','admin');


CREATE TABLE menu(
  id varchar(36) NOT NULL,
  name varchar(45) DEFAULT NULL,
  number int,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX menu_by_id ON proentel_security.menu(id);
insert into menu (id,name,number,isactive,create_by,update_by) values ('37e2e8e3-863b-11ed-ad13-f8a2d67e42de','Geography',1, '1','admin','admin');
insert into menu (id,name,number,isactive,create_by,update_by) values ('37e2fe9c-863b-11ed-ad13-f8a2d67e42de','Operation',2, '1','admin','admin');
insert into menu (id,name,number,isactive,create_by,update_by) values ('37e30fcc-863b-11ed-ad13-f8a2d67e42de','Business',3, '1','admin','admin');
insert into menu (id,name,number,isactive,create_by,update_by) values ('37e3228c-863b-11ed-ad13-f8a2d67e42de','Security',4, '1','admin','admin');


CREATE TABLE entity(
  id varchar(36) NOT NULL,
  name varchar(45) DEFAULT NULL,
  path varchar(45) DEFAULT NULL,
  number int,
  isactive BOOLEAN DEFAULT 1,
  id_menu varchar(36) NOT NULL,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX entity_by_id ON proentel_security.entity(id);
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e8d7ed-863b-11ed-ad13-f8a2d67e42de','city','/city',1, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e90523-863b-11ed-ad13-f8a2d67e42de','contact','/contact',2, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e916c7-863b-11ed-ad13-f8a2d67e42de','country','/country',3, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e92994-863b-11ed-ad13-f8a2d67e42de','customer','/customer',4, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e93b4d-863b-11ed-ad13-f8a2d67e42de','torrera','/torrera',5, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e94e4e-863b-11ed-ad13-f8a2d67e42de','emplazamiento','/emplazamiento',6, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e96040-863b-11ed-ad13-f8a2d67e42de','operator','/operator',7, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e97559-863b-11ed-ad13-f8a2d67e42de','site','/site',8, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e986f3-863b-11ed-ad13-f8a2d67e42de','state','/state',9, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e999b9-863b-11ed-ad13-f8a2d67e42de','work','/work',10, '1','37e2e8e3-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e9abae-863b-11ed-ad13-f8a2d67e42de','user','/user',1, '1','37e3228c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e9be85-863b-11ed-ad13-f8a2d67e42de','function','/function',2, '1','37e3228c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e9d111-863b-11ed-ad13-f8a2d67e42de','rol','/rol',3, '1','37e3228c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e9e36c-863b-11ed-ad13-f8a2d67e42de','detailReception','/detailReception',12, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37e9f56c-863b-11ed-ad13-f8a2d67e42de','detailRequest','/detailRequest',11, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea07c0-863b-11ed-ad13-f8a2d67e42de','detailRequisition','/detailRequisition',10, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea184d-863b-11ed-ad13-f8a2d67e42de','material','/material',1, '1','37e2fe9c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea28a7-863b-11ed-ad13-f8a2d67e42de','materialType','/materialType',2, '1','37e2fe9c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea3b67-863b-11ed-ad13-f8a2d67e42de','measureUnit','/measureUnit',3, '1','37e2fe9c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea4bc9-863b-11ed-ad13-f8a2d67e42de','Reception','/Reception',6, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea5e82-863b-11ed-ad13-f8a2d67e42de','request','/request',7, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea7450-863b-11ed-ad13-f8a2d67e42de','requisition','/requisition',8, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea8751-863b-11ed-ad13-f8a2d67e42de','status','/status',4, '1','37e2fe9c-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37ea9812-863b-11ed-ad13-f8a2d67e42de','stock','/stock',9, '1','37e30fcc-863b-11ed-ad13-f8a2d67e42de','admin','admin');
insert into entity (id,name, path, number, isactive, id_menu,create_by,update_by) values ('37eaaa6c-863b-11ed-ad13-f8a2d67e42de','supplier','/supplier',5, '1','37e2fe9c-863b-11ed-ad13-f8a2d67e42de','admin','admin');






CREATE TABLE `function` (
  id varchar(36) NOT NULL,
  name varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE INDEX function_by_id ON proentel_security.function(id);
insert into `function` (id,name,isactive,create_by,update_by) values ('37ef9495-863b-11ed-ad13-f8a2d67e42de','add', '1','admin','admin');
insert into `function` (id,name,isactive,create_by,update_by) values ('37efb1da-863b-11ed-ad13-f8a2d67e42de','list', '1','admin','admin');
insert into `function` (id,name,isactive,create_by,update_by) values ('37efc8ad-863b-11ed-ad13-f8a2d67e42de','update', '1','admin','admin');
insert into `function` (id,name,isactive,create_by,update_by) values ('37efe213-863b-11ed-ad13-f8a2d67e42de','delete', '1','admin','admin');


CREATE TABLE rol_entity_function (
  id varchar(36) NOT NULL,
  rol_id varchar(36) DEFAULT NULL,
  entity_id varchar(36) DEFAULT NULL,
  function_id varchar(36) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX rol_entity_function_by_id ON proentel_security.rol_entity_function(id);
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e8d7ed-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e8d7ed-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e8d7ed-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e8d7ed-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e90523-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e90523-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e90523-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e90523-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e916c7-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e916c7-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e916c7-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e916c7-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e92994-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e92994-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e92994-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e92994-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e93b4d-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e93b4d-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e93b4d-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e93b4d-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e94e4e-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e94e4e-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e94e4e-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e94e4e-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e96040-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e96040-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e96040-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e96040-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e97559-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e97559-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e97559-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e97559-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e986f3-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e986f3-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e986f3-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e986f3-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e999b9-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e999b9-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e999b9-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e999b9-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9abae-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9abae-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9abae-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9abae-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9be85-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9be85-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9be85-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9be85-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9d111-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9d111-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9d111-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9d111-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9e36c-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9e36c-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9e36c-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9e36c-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9f56c-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9f56c-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9f56c-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37e9f56c-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea07c0-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea07c0-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea07c0-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea07c0-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea184d-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea184d-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea184d-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea184d-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea28a7-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea28a7-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea28a7-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea28a7-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea3b67-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea3b67-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea3b67-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea3b67-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea4bc9-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea4bc9-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea4bc9-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea4bc9-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea5e82-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea5e82-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea5e82-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea5e82-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea7450-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea7450-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea7450-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea7450-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea8751-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea8751-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea8751-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea8751-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea9812-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea9812-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea9812-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37ea9812-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37eaaa6c-863b-11ed-ad13-f8a2d67e42de','37ef9495-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37eaaa6c-863b-11ed-ad13-f8a2d67e42de','37efb1da-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37eaaa6c-863b-11ed-ad13-f8a2d67e42de','37efc8ad-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');
insert into rol_entity_function (id,rol_id,entity_id,function_id,isactive,create_by,update_by) values (UUID(),'37ca9ac4-863b-11ed-ad13-f8a2d67e42de','37eaaa6c-863b-11ed-ad13-f8a2d67e42de','37efe213-863b-11ed-ad13-f8a2d67e42de','1','admin','admin');