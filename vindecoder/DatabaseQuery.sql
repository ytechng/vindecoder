-----------	Create Users Table ------------
CREATE TABLE vd_users (
	id INT(11) AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(100),
	phone_no VARCHAR(15),
	company_name VARCHAR(50),
	company_address VARCHAR(100),
	role VARCHAR(100),
	password VARCHAR(60),
	reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	last_login TIMESTAMP,
	credit INT DEFAULT(1),
	enabled BOOLEAN,
	reset_token CHAR(36),
	
	CONSTRAINT pk_vduser_id PRIMARY KEY (id)
);

-----------	Insert Into Users Table ------------

INSERT INTO vd_users (first_name, last_name, email, phone_no, company_name, company_address, role, password, enabled) 
VALUES ('test', 'user', 'user@gmail.com', '08020908829', 'Whytech Automobile Company', '9 Alarape Street, Langbasa Ajga', 'business', 'test1234', true);

----------- Create Remember-Me Table -------------

CREATE TABLE persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);


-----------	Create VinDecoders Table ------------
CREATE TABLE vd_decoder (
	id INT(11) AUTO_INCREMENT,
	vin VARCHAR(20),
	make VARCHAR(50),
	model_name VARCHAR(100),
	model_year VARCHAR(4),
	fuel_type VARCHAR(20),
	body_type VARCHAR(20),
	drive_wheels VARCHAR(20),
	engine_power VARCHAR(10),
	horse_power VARCHAR(10),
	curb_weight VARCHAR(10),
	gross_vehicle_weight VARCHAR(10),
	plant VARCHAR(50),
	gear_box VARCHAR(10),
	max_payload VARCHAR(10),
	co2_emission_mixed_driving VARCHAR(50),
	fuel_consumption_mixed_driving VARCHAR(50),
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	status BOOLEAN,
	
	CONSTRAINT pk_vddecoder_id PRIMARY KEY (id)
);


-----------	Create VIN Logs Table ------------
CREATE TABLE vd_vin_logs (
	id INT(11) AUTO_INCREMENT,
	user_id INT NOT NULL,
	vin_id VARCHAR(17) NOT NULL,
	log_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT pk_vdvinlog_id PRIMARY KEY (id)
);


----------- Create Credit Table ---------------
CREATE TABLE vd_tanx_logs (
	id INT(11) AUTO_INCREMENT,
	user_id INT NOT NULL,
	created_by INT NOT NULL,
	quantity INT NOT NULL,
	credit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT pk_vdtranxlog_id PRIMARY KEY (id)
);