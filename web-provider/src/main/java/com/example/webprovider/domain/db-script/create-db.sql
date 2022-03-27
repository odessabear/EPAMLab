-- these commands remove all tables from the database
-- netstat -ano | findstr 8080
-- it implies an error if tables not exist in DB, just ignore it
DROP table if exists tariffs;
DROP table if exists orders;
DROP table if exists categories;
DROP table if exists order_statuses;
DROP table if exists users;
DROP table if exists roles;

-- --------------------------------------------------------------
-- ROLES
-- users roles
-- --------------------------------------------------------------
CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(10) UNIQUE NOT NULL
);

INSERT INTO roles
VALUES (0, 'admin');
INSERT INTO roles
VALUES (1, 'client');

-- --------------------------------------------------------------
-- USERS
-- --------------------------------------------------------------
CREATE TABLE users
(
    id            SERIAL PRIMARY KEY                                                 NOT NULL,
    role_id       INTEGER REFERENCES roles (id) ON DELETE CASCADE ON UPDATE RESTRICT NOT NULL,
    email         VARCHAR(128) UNIQUE                                                NOT NULL,
    password      VARCHAR(30)                                                        NOT NULL,
    account_state NUMERIC                                                            NOT NULL DEFAULT 0,
    is_blocked    BOOLEAN                                                            NOT NULL DEFAULT FALSE
);

INSERT INTO users
VALUES (DEFAULT, 0, 'admin@takogo.net', 'adminpass', default, default);
INSERT INTO users
VALUES (DEFAULT, 1, 'client@takogo.net', 'clientpass', default, default);
INSERT INTO users
VALUES (DEFAULT, 1, 'петров@takogo.net', 'петров', default, default);


CREATE TABLE order_statuses
(
    id   INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(10) UNIQUE  NOT NULL
);

INSERT INTO order_statuses
VALUES (0, 'opened');
INSERT INTO order_statuses
VALUES (1, 'paid');
INSERT INTO order_statuses
VALUES (2, 'canceled');


CREATE TABLE categories
(
    id   SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(60) UNIQUE NOT NULL
);

INSERT INTO categories
VALUES (1, 'Internet');
INSERT INTO categories
VALUES (2, 'Telephony');
INSERT INTO categories
VALUES (3, 'IP-TV');
INSERT INTO categories
VALUES (4, 'Cable-TV');


-- --------------------------------------------------------------
-- ORDERS
-- --------------------------------------------------------------
CREATE TABLE orders
(
    id              SERIAL PRIMARY KEY                     NOT NULL,
    user_id         INTEGER REFERENCES users (id)          NOT NULL,
    tariff_id       INTEGER REFERENCES tariffs (id)        NOT NULL,
    order_cost      NUMERIC                                NOT NULL,
    created_date    TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT now() NOT NULL,
    order_status_id INTEGER REFERENCES order_statuses (id) NOT NULL
);


CREATE TABLE tariffs
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(50)                        NOT NULL,
    description   VARCHAR(255)                       NOT NULL,
    image_link    CHARACTER VARYING(255)             NOT NULL,
    price         NUMERIC                            NOT NULL,
    categories_id INTEGER REFERENCES categories (id) NOT NULL
);

-- Internet
INSERT INTO tariffs
VALUES (DEFAULT, 'HomeNet', 'HomeNet_Description', 'image_link', 155, 1); -- 1 (order id)
INSERT INTO tariffs
VALUES (DEFAULT, 'SpeedNet', 'SpeedNet_Description', 'image_link', 185, 1); -- 2
INSERT INTO tariffs
VALUES (DEFAULT, 'HighSpeedNet', 'HighSpeedNet_Description', 'image_link', 220, 1);
-- 3
-- Telephony
INSERT INTO tariffs
VALUES (DEFAULT, 'Home60', 'Home60_Description', 'image_link', 70, 2); -- 4
INSERT INTO tariffs
VALUES (DEFAULT, 'Home100', 'Home100_Description', 'image_link', 110, 2); -- 5
INSERT INTO tariffs
VALUES (DEFAULT, 'Home300', 'Home300_Description', 'image_link', 130, 2);
-- 6
-- IP-TV
INSERT INTO tariffs
VALUES (DEFAULT, 'IP-TV_Basic', 'IP-TV_Basic_Description', 'image_link', 210, 3); -- 7
INSERT INTO tariffs
VALUES (DEFAULT, 'IP-TV_Advanced', 'IP-TV_Advanced_Description', 'image_link', 230, 3);
-- 8
-- Cable TV
INSERT INTO tariffs
VALUES (DEFAULT, 'Standard_TV', 'Standard_TV_Description', 'image_link', 160, 4); -- 9
INSERT INTO tariffs
VALUES (DEFAULT, 'Digital_TV', 'Digital_TV_Description', 'image_link', 260, 4);

-- Internet
INSERT INTO tariffs
VALUES (DEFAULT, 'HomeNet_2', 'HomeNet_2_Description', 'image_link', 175, 1); -- 1 (order id)
INSERT INTO tariffs
VALUES (DEFAULT, 'SpeedNet_2', 'SpeedNet_2_Description', 'image_link', 205, 1); -- 2
INSERT INTO tariffs
VALUES (DEFAULT, 'HighSpeedNet_2', 'HighSpeedNet_2_Description', 'image_link', 240, 1);
-- 3
-- Telephony
INSERT INTO tariffs
VALUES (DEFAULT, 'Home60_2', 'Home60_2_Description', 'image_link', 90, 2); -- 4
INSERT INTO tariffs
VALUES (DEFAULT, 'Home100_2', 'Home100_2_Description', 'image_link', 80, 2); -- 5
INSERT INTO tariffs
VALUES (DEFAULT, 'Home300_2', 'Home300_2_Description', 'image_link', 120, 2);
-- 6
-- IP-TV
INSERT INTO tariffs
VALUES (DEFAULT, 'IP-TV_Basic_2', 'IP-TV_Basic_2_Description', 'image_link', 270, 3); -- 7
INSERT INTO tariffs
VALUES (DEFAULT, 'IP-TV_Advanced_2', 'IP-TV_Advanced_2_Description', 'image_link', 220, 3);
-- 8
-- Cable TV
INSERT INTO tariffs
VALUES (DEFAULT, 'Standard_TV_2', 'Standard TV_2_Description', 'image_link', 180, 4); -- 9
INSERT INTO tariffs
VALUES (DEFAULT, 'Digital_TV_2', 'Digital_TV_2_Description', 'image_link', 280, 4);

