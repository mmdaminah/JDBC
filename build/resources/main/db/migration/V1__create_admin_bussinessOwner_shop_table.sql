create table if not exists admin(
    id serial primary key,
    first_name varchar(72) not null,
    last_name varchar(72) not null,
    username varchar(72) unique not null,
    password varchar(72) not null,
    phone_number varchar(10) unique not null,
    creator integer references admin(id),
    super_admin boolean not null
);
create table if not exists business_owner(
    id serial primary key ,
    first_name varchar(72) not null,
    last_name varchar(72) not null,
    national_code varchar(10) not null,
    phone_number varchar(10) not null,
    creator integer references admin(id) not null
);
create table if not exists shop(
    id serial primary key ,
    name varchar(72) not null,
    description text,
    postal_address text,
    location_address text,
    creator integer references admin(id) not null,
    owner integer not null references business_owner(id) on delete cascade
);
