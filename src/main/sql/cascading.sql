drop table customers;
drop table orders;

create table customers(
    customer_id serial8 primary key,
    name varchar(100) not null,
    age int4
);

create table orders(
    order_id serial8 primary key,
    customer_id int8,
    item_name varchar(100),
    foreign key (customer_id) references customers (customer_id) on delete set null
);

insert into customers (name, age) VALUES ('Tom', 30);

insert into orders (customer_id, item_name) values (1, 'Iphone');

delete from customers where customer_id = 1;