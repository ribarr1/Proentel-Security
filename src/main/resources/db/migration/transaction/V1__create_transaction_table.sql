CREATE TABLE transactions (
  id varchar(36) NOT NULL,
  phone varchar(40) DEFAULT NULL,
  license_plate varchar(10) DEFAULT NULL,
  billboard_code varchar(15) DEFAULT NULL,
  start_date varchar(10) DEFAULT NULL,
  start_time varchar(8) DEFAULT NULL,
  end_date varchar(10) DEFAULT NULL,
  end_time varchar(8) DEFAULT NULL,
  time int(11) DEFAULT NULL,
  price decimal(10,4) DEFAULT NULL,
  closed varchar(1) DEFAULT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT NOW(),
  update_date TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE INDEX transactions_by_license_plate ON ppk_transactions.transactions(license_plate);
CREATE INDEX transactions_by_billboard_code ON ppk_transactions.transactions(billboard_code);

CREATE TRIGGER transactions_update_trigger BEFORE UPDATE ON ppk_transactions.transactions FOR EACH ROW SET new.update_date = NOW();

CREATE TABLE temporal_transactions (
  id varchar(36) NOT NULL,
  phone varchar(40) DEFAULT NULL,
  license_plate varchar(10) DEFAULT NULL,
  billboard_code varchar(15) DEFAULT NULL,
  date varchar(10) DEFAULT NULL,
  hour varchar(8) DEFAULT NULL,
  time int(11) DEFAULT NULL,
  price decimal(10,2) DEFAULT NULL,
  action varchar(1) DEFAULT NULL,
  create_date timestamp NOT NULL DEFAULT NOW(),
  update_date timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE INDEX temporal_transactions_by_license_plate ON ppk_transactions.temporal_transactions(license_plate);
CREATE INDEX temporal_transactions_by_billboard_code ON ppk_transactions.temporal_transactions(billboard_code);

CREATE TRIGGER temporal_transactions_update_trigger BEFORE UPDATE ON ppk_transactions.temporal_transactions FOR EACH ROW SET new.update_date = NOW();

CREATE TABLE billboards (
  id varchar(36) NOT NULL,
  code varchar(15) DEFAULT NULL,
  address varchar(45) DEFAULT NULL,
  create_date timestamp NOT NULL DEFAULT NOW(),
  update_date timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE INDEX billboards_by_code ON ppk_transactions.billboards(code);

CREATE TRIGGER billboards_update_trigger BEFORE UPDATE ON ppk_transactions.billboards FOR EACH ROW SET new.update_date = NOW();

CREATE TABLE rates (
   id varchar(36) NOT NULL,
   date varchar(10) DEFAULT NULL,
   value int(11) DEFAULT NULL,
   status varchar(1) DEFAULT NULL,
   create_date timestamp NOT NULL DEFAULT NOW(),
   update_date timestamp NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE INDEX rates_by_status ON ppk_transactions.rates(status);

CREATE TRIGGER rates_update_trigger BEFORE UPDATE ON ppk_transactions.rates FOR EACH ROW SET new.update_date = NOW();