drop database if exists bd;
create database bd;
use bd;

create table aluno (idAluno int primary key auto_increment, nome varchar (25) not null, email varchar (50) not null unique);
create table disciplina (idDisciplina int, nome varchar (35) not null, id_aluno int, primary key (idDisciplina, id_aluno), foreign key (id_aluno) references aluno(idAluno) on delete cascade);
create table usuario (idUsuario int primary key, login varchar (25) not null unique, senha varchar (10) not null);

insert into aluno values (1, 'admin', 'admin@admin.com');
insert into aluno values (2, 'dba', 'dba@dba.com');
insert into aluno values (3, 'tester', 'tester@tester.com');

insert into disciplina values (1, 'Java', 1);
insert into disciplina values (2, 'Oracle', 2);
insert into disciplina values (3, 'Mysql', 3);

insert into usuario values (1, 'admin', 'admin');
insert into usuario values (2, 'dba', 'dba');
