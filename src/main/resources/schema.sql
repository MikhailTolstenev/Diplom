create schema if not exists s1;

create table if not exists s1.Users (
id serial primary key,
login varchar (255) not null,
password varchar (255) not null,
role varchar (255) not null
 );
 insert into s1.Users (login, password, role)
 values ('user', '$2a$10$NHlwRELJmrr1g.ppPCoN1O7gcuPMtHrl7y5dtMt76LhNHk2mcPywK', 'ROLE_USER');


-- create table if not exists a1.Files (
-- id serial primary key,
-- data bytea,
-- file_name varchar (255) not null,
-- file_size int
---- login varchar (255) not null
-- );