CREATE TABLE author (
    id bigint not null auto_increment,
    name varchar(100) not null,
    nationality varchar(60) not null,
    primary key(id)
) engine=InnoDB default charset=utf8;