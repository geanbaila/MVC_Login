create database agenda;
use agenda;

create table agenda.db.usuario(
	id int not null identity primary key,
	username varchar(60),
	password varchar(60),
	etado char(1)
);

create table agenda.db.usuario_amigo(
	id int not null identity primary key,
	nombres varchar(60),
	apellidos varchar(60),
	usuario_id int
);