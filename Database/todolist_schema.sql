CREATE TABLE todos (
    id uuid PRIMARY KEY,
    text varchar(200) NOT NULL,
    completed bool NOT NULL
);