CREATE TABLE stock (
    id bigint not null auto_increment,
    quantity int not null,
    active boolean not null,
    primary key(id)
) engine=InnoDB default charset=utf8;