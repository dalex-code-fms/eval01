-- ----------------------------------------------------------------------------------------------------
-- ---                                     REBUILD DATABASE                                         ---
-- ----------------------------------------------------------------------------------------------------

DROP DATABASE IF EXISTS FmsCourseShop;
CREATE DATABASE FmsCourseShop;
USE FmsCourseShop;

-- ----------------------------------------------------------------------------------------------------
-- ---                                   BUILD USERS TABLE                                          ---
-- ----------------------------------------------------------------------------------------------------

CREATE TABLE T_Users (
	id				int(4)			PRIMARY KEY AUTO_INCREMENT,
	login			varchar(20)		NOT NULL UNIQUE,
	pwd				varchar(20)		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users ( Login, Password) VALUES ( 'klariany', 'fms123' );

-- ----------------------------------------------------------------------------------------------------
-- ---                               BUILD CUSTOMERS TABLE                                          ---
-- ----------------------------------------------------------------------------------------------------

CREATE TABLE T_Customers (
	id				int(4)			PRIMARY KEY AUTO_INCREMENT,
	firstName		varchar(30)		NOT NULL,
	lastName		varchar(30)		NOT NULL,
	email 			varchar(30)		NOT NULL unique,
	phone 			varchar(20)	,
	address			varchar(50)	,
	idUser			int(4)			NOT NULL,
	FOREIGN KEY (idUser)			REFERENCES T_Users(id)
) ENGINE = InnoDB;

-- ----------------------------------------------------------------------------------------------------
-- ---                                BUILD CATEGORIES TABLE                                        ---
-- ----------------------------------------------------------------------------------------------------

CREATE TABLE T_Categories (
	id					int(4)			PRIMARY KEY AUTO_INCREMENT,
	name				varchar(20)		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Categories ( name ) VALUES ( 'Dev Web' ), ( 'CMS' ), ( 'Office Skills' ), ( 'AI' ), ( 'Cyber Security' ), ( 'Dev' );

-- ----------------------------------------------------------------------------------------------------
-- ---                                   BUILD COURSES TABLE                                        ---
-- ----------------------------------------------------------------------------------------------------

CREATE TABLE T_Courses (
	id					int(4)			PRIMARY KEY AUTO_INCREMENT,
	name				varchar(50)		NOT NULL,
	description			varchar(100)	NOT NULL,
	duration			int(4)			NOT NULL,
	format				varchar(20)		NOT NULL,
	price				float(4)		NOT NULL DEFAULT 10,
	idCategory			int(4),
	FOREIGN KEY (idCategory) 			REFERENCES T_Categories(id)
) ENGINE = InnoDB;

INSERT INTO T_Courses (name, description, duration, format, price, idCategory) VALUES 
('Java', 'Java SE 8 : Syntaxe & Poo', 20, 'remote', 59.99, 6),
('Java Avancé', 'Exceptions, files, JDBC, Threads...', 50, 'remote', 99.99, 6),
('Spring', 'Spring Core/MVC/Security', 123, 'in-person', 150, 1),
('PHP Frameworks', 'Symfony Basics and Advanced', 30, 'remote', 49.00, 1),
('WordPress for Beginners', 'Learn to create websites using WordPress', 15, 'remote', 39.99, 2),
('Office Excel Mastery', 'From basics to advanced Excel techniques', 25, 'remote', 49.99, 3),
('AI Fundamentals', 'Introduction to Artificial Intelligence concepts', 30, 'in-person', 75.00, 4),
('Cyber Security Basics', 'Understanding the fundamentals of Cyber Security', 40, 'remote', 99.00, 5),
('Angular for Beginners', 'Learn the basics of Angular', 40, 'remote', 79.99, 1),
('Advanced CSS', 'Deep dive into CSS with Flexbox and Grid', 30, 'remote', 59.99, 1),
('Data Science with Python', 'Learn data analysis and visualization', 60, 'in-person', 149.99, 4),
('Digital Marketing Strategies', 'Understanding online marketing techniques', 35, 'remote', 69.99, 3),
('Cloud Computing Basics', 'Introduction to cloud platforms', 45, 'remote', 89.99, 1),
('Game Development with Unity', 'Create your own video games using Unity', 80, 'in-person', 199.99, 6);

-- ----------------------------------------------------------------------------------------------------
-- ---                                   BUILD ORDERS TABLE                                         ---
-- ----------------------------------------------------------------------------------------------------

CREATE TABLE T_Orders (
	id				int(4)		PRIMARY KEY AUTO_INCREMENT,
	totalPrice		float(4)	NOT NULL DEFAULT 0,
	dateOrder 		date		NOT NULL DEFAULT NOW(),
	idCustomer      int(4)   	NOT NULL,
	FOREIGN KEY(idCustomer)		REFERENCES T_Customers(id)
) ENGINE = InnoDB;

-- ----------------------------------------------------------------------------------------------------
-- ---                               BUILD ORDER ITEM TABLE                                         ---
-- ----------------------------------------------------------------------------------------------------

CREATE TABLE T_Order_Items (
	id				int(4)		PRIMARY KEY AUTO_INCREMENT,
	idCourse        int(4)   	NOT NULL,
	price			float(4)	NOT NULL DEFAULT 0,
	idOrder         int(4)   	NOT NULL,
	FOREIGN KEY(idCourse) 		REFERENCES T_Courses(id),
	FOREIGN KEY(idOrder) 		REFERENCES T_Orders(id)
) ENGINE = InnoDB;



