set foreign_key_checks = 0;

delete from author;
delete from book;
delete from stock;

set foreign_key_checks = 1;

alter table author auto_increment = 1;
alter table book auto_increment = 1;
alter table stock auto_increment = 1;

insert into author (id, name, nationality) values (1, 'Clarice Lispector', 'Brazilian');
insert into stock (id, quantity, active) values (1, 35, 1);
insert into book (id, title, isbn, price, author_id, stock_id) values (1, 'A bela e a fera', '9788526502758', 0.00, 1, 1);

insert into author (id, name, nationality) values (2, 'Maquiavel', 'Françes');
insert into stock (id, quantity, active) values (2, 100, 0);
insert into book (id, title, isbn, price) values (2, 'O Príncipe', '6502758701664', 0.00);

