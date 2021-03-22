DELETE
FROM meals;
DELETE
FROM user_roles;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO public.meals (id, user_id, datetime, description, calories)
VALUES (100011, 100000, '2021-03-19 13:12:24.000000', 'lunch', 2000),
       (100012, 100000, '2021-03-18 13:12:24.000000', 'lunch', 2000),
       (100013, 100000, '2021-03-17 13:12:24.000000', 'lunch', 2000),
       (100014, 100001, '2021-03-16 13:12:24.000000', 'dinner', 2000);