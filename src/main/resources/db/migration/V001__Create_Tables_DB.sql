CREATE TABLE IF NOT EXISTS ACTORS (
    id              INT             NOT NULL    AUTO_INCREMENT,
    nameactor       VARCHAR(100)    NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS MOVIES (
    id          INT             NOT NULL    AUTO_INCREMENT,
    namemovie   VARCHAR(100)    NOT NULL,
    idactor     INT             NOT NULL,
    idgender    INT             NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS GENDERS (
    id              INT             NOT NULL    AUTO_INCREMENT,
    description     VARCHAR(200)    NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO ACTORS(nameactor) VALUES ('Dwayne Johnson');
INSERT INTO ACTORS(nameactor) VALUES ('Vera Farmiga');
INSERT INTO ACTORS(nameactor) VALUES ('Idris Elba');

INSERT INTO Movies(namemovie, idgender, idactor) VALUES ('The Conjuring 2', 3, 2);
INSERT INTO Movies(namemovie, idgender, idactor) VALUES ('Skyscraper', 2, 1);
INSERT INTO Movies(namemovie, idgender, idactor) VALUES ('Beast', 1, 3);

INSERT INTO GENDERS(description) VALUES ('Suspense');
INSERT INTO GENDERS(description) VALUES ('Ação');
INSERT INTO GENDERS(description) VALUES ('Terror');

ALTER TABLE MOVIES ADD CONSTRAINT FK_MOVIES_ACTORS FOREIGN KEY(idactor) REFERENCES ACTORS(id);
ALTER TABLE MOVIES ADD CONSTRAINT FK_MOVIES_GENDERS FOREIGN KEY(idgender) REFERENCES GENDERS(id);