create table medicine_type(
    id serial primary key,
    name text unique not null
);

create table medicine(
    id serial primary key,
    name text unique not null,
    medicine_type_id int references medicine_type(id),
    price int
);

insert into medicine_type(name) values ('Антибиотики');
insert into medicine_type(name) values ('Жаропонижающие');
insert into medicine_type(name) values ('Сердечные');

insert into medicine(name, medicine_type_id, price) values ('Фуросемид', 3, 100);
insert into medicine(name, medicine_type_id, price) values ('Пенталгин', 2, 150);
insert into medicine(name, medicine_type_id, price) values ('Азактам', 1, 400);
insert into medicine(name, medicine_type_id, price) values ('Трамицент', 1, 90);
insert into medicine(name, medicine_type_id, price) values ('Парацетамол', 2, 50);
insert into medicine(name, medicine_type_id, price) values ('Метопролол', 3, 210);
insert into medicine(name, medicine_type_id, price) values ('Нурофен Форте', 2, 300);
insert into medicine(name, medicine_type_id, price) values ('Небцин', 1, 150);
insert into medicine(name, medicine_type_id, price) values ('Спиронолактон', 3, 250);
insert into medicine(name, medicine_type_id, price) values ('Анальгин', 2, 50);