drop table if exists users cascade;
drop table if exists flat cascade;

create table users (
    id integer primary key generated always as identity,
    email varchar(40) not null unique ,
    userName varchar(20) not null unique ,
    password varchar(20) not null,
    role varchar(20) not null check (role = 'admin' or role = 'client')
        default 'client'
);

create table flat (
    id integer primary key generated always as identity ,
    flatName varchar(30) not null ,
    status varchar(5) check (status = 'free' or status = 'taken') default 'free',
    location varchar(50) not null ,
    cost integer not null
);



