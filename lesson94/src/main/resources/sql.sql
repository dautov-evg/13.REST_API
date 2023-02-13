CREATE TABLE Person(
                       id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name varchar(100) not null,
                       age int,
                       email varchar(100)
);

INSERT INTO Person(name, age, email) VALUES ('Tom', 25, 'tom@mail.ru');
INSERT INTO Person(name, age, email) VALUES ('Bob', 51, 'bob@mail.ru');
INSERT INTO Person(name, age, email) VALUES ('Katy', 38, 'katy@mail.ru');

SELECT * FROM Person;

DROP TABLE Person;

ALTER TABLE Person ADD COLUMN created_at timestamp,
    add column updated_at timestamp,
    add column created_who varchar;