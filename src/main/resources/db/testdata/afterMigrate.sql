set foreign_key_checks = 0;

delete from author;

set foreign_key_checks = 1;

alter table author auto_increment = 1;

insert into author(name, nationality) values ('Clarice Lispector', 'Brazilian');
