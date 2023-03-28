CREATE TABLE MOVIES (
    id          INT             NOT NULL    AUTO_INCREMENT,
    namemovie   VARCHAR(100)    NOT NULL,
    idactor     INT             NOT NULL,
    idgender    INT             NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE MOVIES ADD CONSTRAINT FK_MOVIES_ACTORS FOREIGN KEY(idactor) REFERENCES ACTORS(id);
ALTER TABLE MOVIES ADD CONSTRAINT FK_MOVIES_GENDERS FOREIGN KEY(idgender) REFERENCES GENDERS(id);

INSERT INTO Movies(namemovie, idgender, idactor) VALUES ('The Conjuring 2', 3, 2);
INSERT INTO Movies(namemovie, idgender, idactor) VALUES ('Skyscraper', 2, 1);
INSERT INTO Movies(namemovie, idgender, idactor) VALUES ('Beast', 1, 3);