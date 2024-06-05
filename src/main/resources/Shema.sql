create schema if not exists a1;

create table if not exists a1.Users (
id serial primary key,
login varchar (255) not null,
password varchar (255) not null,
role varchar (255) not null
 );
 insert into a1.Users (login, password, role)
 values ('user', 'password', 'user');


-- create table if not exists a1.Files (
-- id serial primary key,
-- data bytea,
-- file_name varchar (255) not null,
-- file_size int
---- login varchar (255) not null
-- );