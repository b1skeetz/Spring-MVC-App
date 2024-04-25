create table Directors
(
    director_id serial8 primary key,
    name        varchar(100) not null unique,
    age         int4 check (age > 10)
);

create table Movies
(
    movie_id        serial8 primary key,
    director_id     int8         not null,
    name            varchar(200) not null,
    year_production int4 check (year_production > 1900),
    foreign key (director_id) references Directors (director_id)
);


insert into Directors (name, age)
values ('Quentin Tarantino', 57),
       ('Martin Scorsese', 78),
       ('Guy Richie', 52),
       ('Woodie Allen', 85),
       ('David Lynch', 74),
       ('Christopher Nolan', 50);

INSERT INTO Movies(director_id, name, year_production)
VALUES (1, 'Reservoir Dogs', 1992),
    (1, 'Pulp Fiction', 1994),
    (1, 'The Hateful Eight', 2015),
    (1, 'Once Upon a Time in Hollywood', 2019),
    (2, 'Taxi Driver', 1976),
    (2, 'Goodfellas', 1990),
    (2, 'The Wolf of Wall Street', 2013),
    (3, 'Lock, Stock and Two Smoking Barrels', 1998),
    (3, 'Snatch', 2000),
    (4, 'Midnight in Paris', 2011),
    (6, 'Inception', 2010);

select d.name, m.name, m.year_production from Directors d join Movies M on d.director_id = M.director_id;
select d.name, m.name, m.year_production from Directors d left join Movies M on d.director_id = M.director_id;