create database greetings;

use greetings;

CREATE TABLE users (
  id BIGINT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE authorities (
  id BIGINT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_messages (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name CHAR(128) NOT NULL,
  message CHAR(255),
  image_uri CHAR(255),
  user_id bigint,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username,authority);

INSERT INTO users (username, password, enabled) values ('mohsin', '$2a$10$a07FaSKwo2xAwEj4UJYa0etu8sY5o9onG/0psQ2FxzjviueQUYnbm',1);
-- user password as 'pass' for login
INSERT INTO authorities (username, authority) values ('mohsin', 'ROLE_USER');