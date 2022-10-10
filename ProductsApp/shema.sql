create table products.recipe
(
    id       serial primary key,
    category varchar(255),
    calories int check ( calories >= 0 ),
    kitchen  varchar(255)
);

create table products.ingridient
(
    id serial primary key,
    name varchar(255) not null,
    proteins int check ( proteins>=0 ),
    fat int check ( fat>=0 ),
    carbonates int check ( carbonates>=0 ),
    calories int check ( calories>=0 )

);