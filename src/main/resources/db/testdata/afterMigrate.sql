set foreign_key_checks = 0;

delete from author;
delete from book;

set foreign_key_checks = 1;

alter table author auto_increment = 1;
alter table book auto_increment = 1;

insert into author(name, nationality) values ('Clarice Lispector', 'Brazilian');

insert into book (title, isbn, author_id) values ('A bela e a fera', '9788526502758', 1);