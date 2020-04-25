create database if not exists shop default charset utf8

use shop;

create table products
(
    id   int auto_increment primary key,
    name varchar(50) not null
);

create table sellers
(
    id         int auto_increment primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null
);

create table buyers
(
    id         int auto_increment primary key,
    first_name varchar(50)        not null,
    last_name  varchar(50)        not null,
    login      varchar(50) unique not null,
    password   varchar(50)        not null

);

create table stock
(
    id      int auto_increment primary key,
    product int         not null references products (id),
    seller  int         not null references sellers (id),
    amount  int         not null,
    cost    float(7, 2) not null
);

create table orders
(
    id         int auto_increment primary key,
    id_buyer   int not null references buyers (id),
    id_product int not null references stock (id),
    quantity   int not null
);

insert into products (name)
values ('product 1'),
       ('product 2'),
       ('product 3'),
       ('product 4');

insert into sellers (first_name, last_name)
values ('First', 'First'),
       ('Second', 'Second');

insert into stock (product, seller, amount, cost)
values (1, 1, 10, 10.10),
       (2, 2, 20, 20.20),
       (3, 1, 30, 40.10),
       (4, 2, 30, 30.20);

insert into buyers (first_name, last_name, login, password)
values ('First', 'First', 'First', 'First'),
       ('Second', 'Second', 'Second', 'Second');
