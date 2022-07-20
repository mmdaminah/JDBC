create table if not exists admins
(
    id            serial primary key,
    first_name    varchar(72),
    last_name     varchar(72),
    username      varchar(72) not null unique,
    password      varchar(72) not null,
    national_code varchar(10) not null
);
