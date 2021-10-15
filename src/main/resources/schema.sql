DROP TABLE IF EXISTS books;

CREATE TABLE books(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    author     VARCHAR(250) NOT NULL,
    title      VARCHAR(250) NOT NULL,
    priceOld   VARCHAR(250) DEFAULT NULL,
    price      VARCHAR(250) DEFAULT NULL,
    discount   INT          DEFAULT NULL,
    bestseller BOOLEAN      DEFAULT NULL,
    recomended BOOLEAN      DEFAULT NULL,
    news       BOOLEAN      DEFAULT NULL,
    popular    BOOLEAN      DEFAULT NULL
);

DROP TABLE IF EXISTS genres;

CREATE TABLE genres(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    genre      VARCHAR(250) NOT NULL,
    parent_id  INT          NOT NULL,
    level      INT
);

DROP TABLE IF EXISTS authors;

CREATE TABLE authors(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    author     VARCHAR(250) NOT NULL
);

create INDEX ind_author on authors(author);