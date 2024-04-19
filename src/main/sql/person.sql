drop table Person;
create table Person(
                       id serial8 primary key,
                       name varchar(30),
                       age int4,
                       email varchar(30)
);

insert into Person (name, age, email) VALUES ('Tom', 23, 'tom@mail.ru'),
                                             ('Bob', 55, 'bob@mail.ru'),
                                             ('John', 36, 'john@mail.ru');

insert into Person (name, age, email) VALUES ('Peter', 15, 'peter@gmail.com');

select * from Person;