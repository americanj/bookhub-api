CREATE TABLE book (
	id bigint not null AUTO_INCREMENT,
  	title varchar(255) not null,
  	isbn varchar(255) not null,
  	author_id bigint not null,
  	primary key(id),
  	foreign key (author_id) references author(id)
) engine=InnoDB default charset=utf8;