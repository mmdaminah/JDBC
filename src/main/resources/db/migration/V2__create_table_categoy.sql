create table if not exists category(
  id serial primary key ,
  title varchar(72) not null ,
  slug varchar(128),
  english_title varchar(72),
  parent_category integer references category(id)
);
create table if not exists category_shop(
    shop_id integer references shop(id),
    category_id integer references category(id),
    primary key (shop_id,category_id)
);

create table if not exists working_days(
    id serial primary key ,
    persian_title varchar(72) ,
    english_title varchar(72) ,
    holiday boolean,
    full_time boolean,
    shop integer references shop(id) unique,
    unique (persian_title,english_title,shop)
);
create table if not exists working_hours(
    id serial primary key ,
    start_time varchar(5) ,
    end_time varchar(5)  ,
    working_day integer references working_days(id),
    unique (start_time,end_time,working_day)
);