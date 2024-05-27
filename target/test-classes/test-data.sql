START TRANSACTION;

 DROP TABLE IF EXISTS shards, orders, characters, location, orders_characters CASCADE;

 create table location (
 	location_id INT PRIMARY KEY,
 	name VARCHAR(10) NOT NULL,
 	population INT NOT NULL
 );

 create table characters (
 	character_id SERIAL PRIMARY KEY,
 	name VARCHAR(60) NOT NULL,
 	gender VARCHAR(60) NOT NULL,
 	nationality VARCHAR(60) NOT NULL,
 	location_id int REFERENCES location(location_id)
 );

 create table shards (
 	shardblade_id SERIAL PRIMARY KEY,
 	shardblade_name VARCHAR(20) UNIQUE,
 	shardblade_type VARCHAR(30) NOT NULL,
 	character_id int REFERENCES characters(character_id)
 );

 create table orders (
 	order_id INT PRIMARY KEY,
 	name VARCHAR(20) UNIQUE
 );

 CREATE TABLE orders_characters(
 	order_id int REFERENCES orders(order_id),
 	character_id int REFERENCES characters(character_id),
 	ideal INT DEFAULT(1) NOT NULL,
 	PRIMARY KEY (order_id, character_id)
 );

insert into location (location_id, name, population)
values (1, 'Test1', 000001),
(2, 'Test2', 000002),
(3, 'Test3', 000003),
(4, 'Test4', 000004);

insert into characters (name, gender, nationality, location_id)
values ('nameTest1', 'genderTest1', 'nationTest1', 1),
('nameTest2', 'genderTest2', 'nationTest2', 2),
('nameTest3', 'genderTest3', 'nationTest3', 3),
('nameTest4', 'genderTest4', 'nationTest4', 4);

insert into shards (shardblade_name, shardblade_type, character_id)
values ('nameTest1', 'typeTest1', 1),
('nameTest2', 'typeTest1', 2),
('nameTest3', 'typeTest2', 3),
('nameTest4', 'typeTest2', 4);

insert into orders (order_id, name)
values (1, 'nameTest1'),
(2, 'nameTest2'),
(3, 'nameTest3');

insert into orders_characters(order_id, character_id, ideal)
values (1, 1, 1),
(2, 2, 2),
(3, 3, 3);


COMMIT;