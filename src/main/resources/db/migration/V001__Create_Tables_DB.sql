CREATE TABLE ACTOR (
    id              INT             NOT NULL    AUTO_INCREMENT,
    nameactor       VARCHAR(100)    NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE GENDER (
    id              INT             NOT NULL    AUTO_INCREMENT,
    description     VARCHAR(200)    NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE MOVIE (
    id          INT             NOT NULL    AUTO_INCREMENT,
    namemovie   VARCHAR(100)    NOT NULL,
    idactor     INT             NOT NULL,
    idgender    INT             NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO ACTOR(nameactor) VALUES ('Dwayne Johnson');
INSERT INTO ACTOR(nameactor) VALUES ('Vera Farmiga');
INSERT INTO ACTOR(nameactor) VALUES ('Idris Elba');

INSERT INTO MOVIE(namemovie, idgender, idactor) VALUES ('The Conjuring 2', 3, 2);
INSERT INTO MOVIE(namemovie, idgender, idactor) VALUES ('Skyscraper', 2, 1);
INSERT INTO MOVIE(namemovie, idgender, idactor) VALUES ('Beast', 1, 3);

INSERT INTO GENDER(description) VALUES ('Suspense');
INSERT INTO GENDER(description) VALUES ('Ação');
INSERT INTO GENDER(description) VALUES ('Terror');

ALTER TABLE MOVIE ADD CONSTRAINT FK_MOVIE_ACTOR FOREIGN KEY(idactor) REFERENCES ACTOR(id);
ALTER TABLE MOVIE ADD CONSTRAINT FK_MOVIE_GENDER FOREIGN KEY(idgender) REFERENCES GENDER(id);