CREATE TABLE IF NOT EXISTS Goods
(
    id          TEXT PRIMARY KEY,
    name        varchar(32) not null,
    description text,
    costs       int         not null
);
CREATE TABLE if not exists Users
(
    id           TEXT PRIMARY KEY,
    first_name   varchar(32) not null,
    last_name    varchar(32) not null,
    email        varchar(32) not null,
    password     varchar(64) not null,
    login        varchar(32) not null,
    phone_number varchar(32) not null,
    role varchar(16)
);
CREATE TABLE if not exists Orders
(
    id               TEXT PRIMARY KEY,
    client_id        TEXT not null,
    expiry_date_time timestamp ,
    is_closed bool ,
    total_cost int not null
);
CREATE TABLE If NOT EXISTS order_item
(
    order_id text not null ,
    item_id text not null ,
    foreign key (order_id) references Orders (id) on delete cascade,
    foreign key (item_id) references Goods (id) on delete cascade
);