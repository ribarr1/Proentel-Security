CREATE TABLE operators (
  id varchar(36) NOT NULL,
  document_type varchar(45) DEFAULT NULL,
  document_number varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  address varchar(100) DEFAULT NULL,
  personal_phone varchar(20) DEFAULT NULL,
  assigned_phone varchar(20) DEFAULT NULL,
  status varchar(2) DEFAULT NULL,
  create_date timestamp NULL DEFAULT NULL,
  update_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE INDEX operators_by_document ON ppk_operators.operators(document_type,document_number);
CREATE TRIGGER operators_update_trigger BEFORE UPDATE ON ppk_operators.operators FOR EACH ROW SET new.update_date = NOW();

CREATE TABLE work_codes (
  id varchar(36) NOT NULL,
  operatorId varchar(36) DEFAULT NULL,
  billaboardId varchar(36) DEFAULT NULL,
  authorization_code varchar(6) DEFAULT NULL,
  status varchar(1) DEFAULT NULL,
  create_date timestamp NULL DEFAULT NULL,
  update_date timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE INDEX work_codes_by_authorization_code ON ppk_operators.work_codes(authorization_code);
CREATE TRIGGER work_codes_update_trigger BEFORE UPDATE ON ppk_operators.work_codes FOR EACH ROW SET new.update_date = NOW();

