CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE greeting
(
    id             UUID PRIMARY KEY,
    message_format VARCHAR(100) UNIQUE      NOT NULL,
    created_at     TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at     TIMESTAMP WITH TIME ZONE NOT NULL
);

INSERT INTO greeting
VALUES (gen_random_uuid(), 'Hello %s', NOW(), NOW()),
       (gen_random_uuid(), 'Hey %s', NOW(), NOW()),
       (gen_random_uuid(), 'Guten Tag %s!', NOW(), NOW()),
       (gen_random_uuid(), 'Konichiwa %s', NOW(), NOW()),
       (gen_random_uuid(), 'What''s up %s!', NOW(), NOW());
