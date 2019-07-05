CREATE TABLE greeting
(
    id             INTEGER PRIMARY KEY      NOT NULL,
    message_format VARCHAR(100) UNIQUE      NOT NULL,
    created_at     TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at     TIMESTAMP WITH TIME ZONE NOT NULL
);

INSERT INTO greeting
VALUES (1, 'Hello %s', NOW(), NOW()),
       (2, 'Hey %s', NOW(), NOW()),
       (3, 'Guten Tag %s!', NOW(), NOW()),
       (4, 'Konichiwa %s', NOW(), NOW()),
       (5, 'What''s up %s!', NOW(), NOW());

CREATE SEQUENCE hibernate_sequence;
