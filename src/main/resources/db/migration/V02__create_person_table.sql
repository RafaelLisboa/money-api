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
VALUES ('Rafael Borges', TRUE, 'Av. Bla bla bla', '1311', 'Casa 8', 'Jabaquara', '0404420', 'São Paulo', 'SP');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('João Jeans', TRUE, 'Rua das Calças', '3311', null, 'Vestimentas', '0435700', 'Calçalandia', 'CL');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('Maria Abacaxi', TRUE, 'Rua Frutas Maduras', '15', 'Ao Lado da Maça', 'Feira', '008366', 'Barraca de Abacaxi',
        'FR');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('Pedro Alvares', 1, 'Rua Itapeva', '352', 'Ap 8 Bloco C', 'Paulista', '05352100', 'Capelinha', 'RJ');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('Ricardo Felles', 1, 'Rua Sem Saida', '000', null, 'Americana', '68435151', 'Estadunidense', 'EU');
INSERT INTO person (name, active, public_place, number, complement, district, postal_code, city, state)
VALUES ('Marley Pererira', 0, 'Rua Pombal Cruzes', '1475', 'Ao lado do Metro', 'Divineia', '23554153', 'Elemar', 'RO');
