create table Actors
(
    actor_id serial8 primary key,
    name     varchar(100) not null unique,
    age      int check (age > 0)
);

INSERT INTO Actors(name, age)
VALUES ('Harvey Keitel', 81),
       ('Robert De Niro', 77),
       ('Leonardo DiCaprio', 46),
       ('Jason Statham', 53),
       ('Joe Pesci', 77),
       ('Samuel L. Jackson', 72);


create table Actors_Movies
(
    actor_id int8,
    movie_id int8,
    primary key (actor_id, movie_id),
    foreign key (actor_id) references Actors (actor_id),
    foreign key (movie_id) references movies (movie_id)
);

INSERT INTO Actors_Movies
VALUES (1, 1),
       (1, 2),
       (2, 5),
       (2, 6),
       (3, 4),
       (3, 7),
       (3, 11),
       (4, 8),
       (4, 9),
       (5, 6),
       (6, 2),
       (6, 3);

select a.name as Actor, m.name as Movie, d.name as Director
from Actors a
         join Actors_Movies AM on a.actor_id = AM.actor_id
         join movies m         on AM.movie_id = m.movie_id
         join directors d      on m.director_id = d.director_id;