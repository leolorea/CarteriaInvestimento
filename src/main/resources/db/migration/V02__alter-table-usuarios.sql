create table usuarios(
id bigint primary key not null auto_increment,
nome varchar(100) not null,
login varchar(100) not null,
senha varchar(100) not null,
phone varchar(100));