CREATE TABLE person
(
    id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(50) NOT NULL,
    active       BOOLEAN     NOT NULL,
    public_place VARCHAR(30),
    number       VARCHAR(30),
    complement   VARCHAR(30),
    district     VARCHAR(30),
    postal_code  VARCHAR(30),
    city         VARCHAR(30),
    state        VARCHAR(30)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('Rafael Borges', TRUE, 'Av. Santa Catarina', '1311', 'Casa 8', 'Jabaquara', '04378300', 'São Paulo', 'SP');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('João Jeans', TRUE, 'Rua das Calças', '3311', null, 'Vestimentas', '0435700', 'Calçalandia', 'CL');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('Maria Abacaxi', TRUE, 'Rua Frutas Maduras', '15', 'Ao Lado da Maça', 'Feira', '008366', 'Barraca de Abacaxi',
        'FR');

