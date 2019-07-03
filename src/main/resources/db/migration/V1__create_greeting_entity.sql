CREATE TABLE greeting
(
    id             INTEGER PRIMARY KEY NOT NULL,
    message_format VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO greeting
VALUES (1, 'Hello %s'),
       (2, 'Hey %s'),
       (3, 'Guten Tag %s!'),
       (4, 'Konichiwa %s'),
       (5, 'What''s up %s!');

CREATE SEQUENCE hibernate_sequence;