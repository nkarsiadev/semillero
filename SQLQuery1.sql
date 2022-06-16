CREATE TABLE Usuario (
	id int IDENTITY(1,1) NOT NULL,
	ci varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	nombre varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	apellido varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	fechaNacimiento datetime NOT NULL,
	salarioPromedio float NOT NULL,
	CONSTRAINT PK__Usuario PRIMARY KEY (id)
);