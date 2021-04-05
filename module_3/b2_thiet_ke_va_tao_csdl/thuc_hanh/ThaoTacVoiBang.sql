drop database if exists thao_tac_voi_bang;
create database thao_tac_voi_bang;
use thao_tac_voi_bang;
CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(25),
  contact_type VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

DROP TABLE suppliers;

ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id;
    
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
  
ALTER TABLE contacts
  CHANGE COLUMN contact_type ctype
    varchar(20) NOT NULL;
    
ALTER TABLE contacts
  DROP COLUMN ctype;
  

ALTER TABLE contacts
  RENAME TO people;
    