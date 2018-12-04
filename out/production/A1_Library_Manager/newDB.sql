DROP DATABASE IF EXISTS cs230library;
CREATE DATABASE IF NOT EXISTS cs230library;
USE cs230library;
CREATE TABLE resources ( 
    resource_id   INT NOT NULL auto_increment, 
    image_id      CHAR(36), 
    resource_type VARCHAR(6), 
    title         VARCHAR(255), 
    release_year  SMALLINT,
    status        BIT,
    PRIMARY KEY (resource_id) 
  );
CREATE TABLE book ( 
    resource_id INT,
    author      VARCHAR(60), 
    publisher   VARCHAR(60), 
    genre       VARCHAR(255), 
    isbn     	CHAR(13), 
    language 	VARCHAR(40), 
    PRIMARY KEY (resource_id) 
   );
CREATE TABLE dvd (
	resource_ID 	  INT,
	director 		  VARCHAR(255),
	runtime 		  SMALLINT,
	language 		  VARCHAR(40),
	subtitleLanguages VARCHAR(255),
	PRIMARY KEY 	  (resource_ID)
);
CREATE TABLE laptop (
	resource_ID  INT NOT NULL AUTO_INCREMENT,
	manufacturer varchar(60),
	model 		 varchar(60),
	os 			 varchar(40),
	PRIMARY KEY (resource_ID)
);
CREATE TABLE copy (
	copy_ID 	int not null auto_increment,
	resource_ID int,
	active 		bit,
	PRIMARY KEY (copy_ID),
	FOREIGN KEY (resource_ID) REFERENCES resources(resource_ID)
);
CREATE TABLE users (
	username 	 varchar(255),
	fName 		 varchar(20),
	sName 		 varchar(20),
	phone_number char(15),
  address_ID int,
  balance DECIMAL,
  avatar_ID CHAR(36),
	active 		 bit,
	PRIMARY KEY (username),
  FOREIGN KEY (address_ID) REFERENCES address(address_ID)
);
CREATE TABLE address (
  address_ID int NOT NULL AUTO_INCREMENT,
  post_code 	 varchar(8),
  house_name 	 varchar(40),
  street_name  varchar(40),
  city 		 varchar(40),
  county 		 varchar(40),
  PRIMARY KEY (address_ID)
);
CREATE TABLE librarian (
	staff_ID 		int not null auto_increment,
	username 		varchar(255),
	employment_date date,
	active bit,
	PRIMARY KEY (staff_ID),
	FOREIGN KEY (username) REFERENCES users(username)
);
CREATE TABLE fine (
  fine_ID int not null AUTO_INCREMENT,
  copy_ID int,
  amount DECIMAL,
  active bit,
  PRIMARY KEY (fine_ID),
  FOREIGN KEY (copy_ID) REFERENCES copy(copy_ID)
);
CREATE TABLE loan (
	copy_ID 	  int not null auto_increment,
	username 	  varchar(255),
	loan_datetime datetime,
	active 		  bit,
	PRIMARY KEY(copy_ID,username,loan_datetime)
);
INSERT INTO `address` VALUES (1, 'SA1 3BH', '1', 'The street', 'Swansea', 'West Glamorgan');

INSERT INTO `users` (`username`, `fName`, `sName`, `phone_number`, `address_ID`, `balance`, `avatar_ID`, `active`) VALUES ('User1234', 'John', 'Smith', '01234567890', '1', '0', '010000000000000000000000000000000001', b'1');

INSERT INTO `resources` VALUES ('1', '010000000000002000000000000000000001', 'book', 'A tale of two cities', '1859');