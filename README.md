# Conduit - Spring Boot + MySql

##Development

###Databse Setup - MySQl
create database conduitspring;

create user conduitspring @localhost  IDENTIFIED by 'conduitspring';

grant all privileges on conduitspring.* to conduitspring@localhost; 
