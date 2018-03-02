CREATE TABLE client(
	id BIGINT PRIMARY KEY,
	name VARCHAR(50),
	age INTEGER NOT NULL,
	profession_id INTEGER REFERENCES profession(id)
);

CREATE SEQUENCE client_id_seq
START WITH 1 INCREMENT BY 1;

CREATE TABLE profession(
	id BIGINT PRIMARY KEY,
	name VARCHAR(50)
);

CREATE SEQUENCE profession_id_seq
START WITH 1 INCREMENT BY 1;

CREATE TABLE clients_telephone(
	id BIGINT PRIMARY KEY,
	number VARCHAR(9),
	client_id INTEGER REFERENCES client(id)
);

CREATE SEQUENCE clients_telephone_id_seq
START WITH 1 INCREMENT BY 1;


