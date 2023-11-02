drop table if exists employee;
drop table if exists position;
drop table if exists department;

create table employee
(
    tabNum varchar(16) primary key,
    fullName varchar(255),
    personId int,
    positionId int
);

create table position
(
    id int primary key,
    name varchar(255),
    departmentId int
);

create table department
(
    id int primary key,
    name varchar(255)
);
