create table Citizens
(
    citizen_id serial8 primary key,
    name       varchar(100) not null,
    age        int check (age > 0)
);

create table Passports
(
    citizen_id      int8 primary key,
    passport_number int,
    foreign key (citizen_id) references Citizens (citizen_id)
);

INSERT INTO Citizens(name, age)
VALUES ('Bob', 12),
       ('Tom', 24),
       ('Katy', 39),
       ('Alice', 45);

INSERT INTO Passports(citizen_id, passport_number)
VALUES (1, 12345),
       (2, 75124),
       (3, 91245),
       (4, 19259);

insert into Citizens (name, age) VALUES ('Jane', 12);

select c.name, c.age, P.passport_number from Citizens c left join Passports P on c.citizen_id = P.citizen_id;
