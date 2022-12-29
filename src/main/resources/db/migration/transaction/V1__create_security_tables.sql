CREATE TABLE countries (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  iso varchar(3) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX countries_by_code ON proentel_geography.countries(code);

CREATE TABLE states (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  code_country varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX states_by_code ON proentel_geography.states(code);

CREATE TABLE emplazamientos (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  address varchar(45) DEFAULT NULL,
  code_torrera varchar(45) DEFAULT NULL,
  code_city varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX emplazamientos_by_code ON proentel_geography.emplazamientos(code);

CREATE TABLE cities (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  code_state varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
  update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX cities_by_code ON proentel_geography.cities(code);

CREATE TABLE sites (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  code_operator varchar(45) DEFAULT NULL,
  code_emplazamiento varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX sites_by_code ON proentel_geography.sites(code);

CREATE TABLE torreras (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX torreras_by_code ON proentel_geography.torreras(code);

CREATE TABLE works (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  large_description varchar(45) DEFAULT NULL,
  short_description varchar(45) DEFAULT NULL,
  start_date TIMESTAMP DEFAULT NOW(),
  end_date TIMESTAMP DEFAULT NOW(),
  code_customer varchar(45) DEFAULT NULL,
  code_site varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX works_by_code ON proentel_geography.works(code);


CREATE TABLE operators (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX operators_by_code ON proentel_geography.operators(code);

CREATE TABLE customers (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX customers_by_code ON proentel_geography.customers(code);

CREATE TABLE contacts (
  id varchar(36) NOT NULL,
  code varchar(45) DEFAULT NULL,
  id_number varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  rol varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  code_customer varchar(45) DEFAULT NULL,
  isactive BOOLEAN DEFAULT 1,
  create_by varchar(45) DEFAULT NULL,
    update_by varchar(45) DEFAULT NULL,
  create_date TIMESTAMP DEFAULT NOW(),
  update_date TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);
CREATE INDEX contacts_by_code ON proentel_geography.contacts(code);

