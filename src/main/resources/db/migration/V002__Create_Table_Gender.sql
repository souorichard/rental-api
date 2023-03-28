CREATE TABLE GENDERS (
    id              INT             NOT NULL    AUTO_INCREMENT,
    description     VARCHAR(200)    NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO GENDERS(description) VALUES ('Suspense');
INSERT INTO GENDERS(description) VALUES ('Ação');
INSERT INTO GENDERS(description) VALUES ('Terror');