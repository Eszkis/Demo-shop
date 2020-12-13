drop table if exists product;
drop table if exists product_category;
drop table if exists customer;
drop table if exists supplier;
drop table if exists user_data;

create table customer
(
    id         serial  not null
        constraint customer_pk
            primary key,
    first_name text    not null,
    last_name  text    not null,
    country    text    not null,
    city       text    not null,
    address    text    not null,
    zip_code   integer not null,
    email      text    not null,
    phone      text    not null
);

create unique index customer_id_uindex
    on customer (id);

create table product_category
(
    id        serial not null
        constraint productcategory_pk
            primary key,
    department text   not null,
    name      text   not null
);
create unique index productcategory_id_uindex
    on product_category (id);

create table supplier
(
    id   serial not null
        constraint supplier_pk
            primary key,
    name text
);

create unique index supplier_id_uindex
    on supplier (id);

create table product
(
    id               serial           not null
        constraint product_pk
            primary key,
    default_price    double precision not null,
    default_currency text             not null,
    product_category integer          not null,
    supplier         integer          not null,
    picture_name     text             not null,
    description      text             not null,
    name             text             not null,
    foreign key (supplier) references supplier (id),
    foreign key (product_category) references product_category (id)
);
create unique index product_id_uindex
    on product (id);



CREATE TABLE user_data (
    id serial not null,
    username text,
    password text,
    email text
);

INSERT INTO public.product_category (id, name, department)
VALUES (1, 'Progbasics', 'Python'),
       (2, 'WEB', 'Javascript&SQL'),
       (4, 'All category', 'All category'),
       (3, 'OOP', 'Java');

INSERT INTO public.supplier (id, name)
VALUES (1, 'marci'),
       (2, 'eszkis'),
       (3, 'dominik'),
       (5, 'All supplier'),
       (4, 'omar');

INSERT INTO public.product (id, name, picture_name, default_price, default_currency,
                            description, product_category, supplier)
VALUES (1, 'Prog-1Week-Mentorbot', 'Prog-1Week-Mentorbot-Marci.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 1),
       (2, 'Prog-2Week-Hangman', 'Prog-2Week-Hangman-Eszkis.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 2),
       (3, 'Prog-2Week-Hangman', 'Prog-2Week-Hangman-Marci.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 1),
       (4, 'Prog-3Week-TicTacToe', 'Prog-3Week-TicTacToe-Eszkis.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 2),
       (5, 'Prog-4Week-Battleship', 'Prog-4Week-Battleship-Omar.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 4),
       (6, 'Prog-5Week-ERP', 'Prog-5Week-ERP-Eszkis.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 2),
       (7, 'Prog-5Week-SecureERP', 'Prog-5Week-SecureERP-Marci.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 1),
       (8, 'Prog-6Week-RogueLikeGame', 'Prog-6Week-RogueLikeGame-Omar.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 4),
       (9, 'Prog-6Week-RougeLikeGame', 'Prog-6Week-RougeLikeGame-Eszkis.png', 24.9, 'USD',
        'Quality demo from quality supplier.', 1, 2),
       (10, 'WEB-1Week-AskMate1', 'WEB-1Week-AskMate1-Eszkis.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 2),
       (11, 'WEB-1Week-AskMate', 'WEB-1Week-AskMate-Dominik.jpg', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 3),
       (12, 'WEB-1Week-AskMate', 'B-1Week-AskMate-Omar.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 4),
       (13, 'WEB-2Week-AskMate2', 'WEB-2Week-AskMate2-Eszkis.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 2),
       (14, 'WEB-2Week-AskMate2', 'WEB-2Week-AskMate2-Omar.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 4),
       (15, 'WEB-3Week-AskMate3', 'WEB-3Week-AskMate3-Eszkis.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 2),
       (16, 'WEB-3Week-AskMate3', 'WEB-3Week-AskMate3-Omar.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 4),
       (17, 'WEB-4Week-FreeStyleJavascript', 'WEB-4Week-FreeStyleJavascript-Eszkis.png', 39.9,
        'USD', 'Quality demo from quality supplier.', 2, 2),
       (18, 'WEB-4Week-FreestyleJavaScript', 'WEB-4Week-FreestyleJavaScript-Marci.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 1),
       (19, 'WEB-5Week-ProMan', 'WEB-5Week-ProMan-Dominik.jpg', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 3),
       (20, 'WEB-5Week-ProMan', 'WEB-5Week-ProMan-Eszkis.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 2),
       (21, 'WEB-5Week-ProMan', 'WEB-5Week-ProMan-Marci.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 1),
       (22, 'WEB-6Week-ProMan2', 'WEB-6Week-BroMan2-Omar.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 4),
       (23, 'WEB-6Week-ProMan2', 'WEB-6Week-ProMan2-Eszkis.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 2),
       (24, 'WEB-6Week-ProMan', 'WEB-6Week-ProMan-Dominik.jpg', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 3),
       (25, 'WEB-7week-PetProject', 'WEB-7week-PetProject-Eszkis.png', 39.9, 'USD',
        'Quality demo from quality supplier.', 2, 2),
       (26, 'OOP-1Week-FiveInARow', 'OOP-1Week-FiveInARow-Dominik.jpg', 49.9, 'USD',
        'Quality demo from quality supplier.', 3, 4),
       (27, 'OOP-1Week-FiveInARow', 'OOP-1Week-FiveInARow-Eszkis.png', 49.9, 'USD',
        'Quality demo from quality supplier.', 3, 2),
       (28, 'OOP-1Week-FiveInRow', 'OOP-1Week-FiveInRow-Omar.png', 49.9, 'USD',
        'Quality demo from quality supplier.', 3, 4),
       (29, 'OOP-2Week-ProcessWatch', 'OOP-2Week-ProcessWatch-Dominik.jpg', 49.9, 'USD',
        'Quality demo from quality supplier.', 3, 3),
       (30, 'OOP-2Week-ProcessWatch', 'OOP-2Week-ProcessWatch-Marci.png', 49.9, 'USD',
        'Quality demo from quality supplier.', 3, 1),
       (31, 'OOP-3Week-DungeonCrawl', 'OOP-3Week-DungeonCrawl-Eszkis.png', 49.9,
        'USD', 'Quality demo from quality supplier.', 3, 2),
       (32, 'OOP-4Week-DungeonCrawl', 'OOP-4Week-DungeonCrawl-Dominik.jpg', 49.9, 'USD',
        'Quality demo from quality supplier.', 3, 3),
       (33, 'OOP-5Week-CodecoolShop', 'OOP-5Week-CodecoolShop-Dominik.png', 69.9, 'USD',
        'Definitely not our current presentation', 3, 3);
