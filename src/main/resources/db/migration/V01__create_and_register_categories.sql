
CREATE TABLE category (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL
)ENGINE  = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO category (category_name) VALUES ('Lazer');
INSERT INTO category (category_name) VALUES ('Alimentação');
INSERT INTO category (category_name) VALUES ('Supermercado');
INSERT INTO category (category_name) VALUES ('Farmácia');
INSERT INTO category (category_name) VALUES ('Outros');