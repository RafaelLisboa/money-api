CREATE TABLE launch
(
    id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description  VARCHAR(50)    NOT NULL,
    due_date     DATE           NOT NULL,
    payment_date DATE,
    value        DECIMAL(10, 2) NOT NULL,
    obs          VARCHAR(100),
    type         VARCHAR(20)    NOT NULL,
    category_id  BIGINT(20)     NOT NULL,
    person_id    BIGINT(20)     NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (person_id) REFERENCES person (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `type`, `category_id`, `person_id`)
VALUES ('Aluguel', '2019-03-31', '2019-03-31', '850.00', 'DESPESA', '5', '1');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `type`, `category_id`, `person_id`)
VALUES ('IPVA', '2019-04-12', '2019-04-12', '342.63', 'DESPESA', '5', '2');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `obs`, `type`, `category_id`, `person_id`)
VALUES ('Almoço', '2019-04-23', '2019-04-23', '620.50', 'Aniversário', 'DESPESA', '2', '2');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `obs`, `type`, `category_id`, `person_id`)
VALUES ('Cinema', '2019-04-25', '2019-04-25', '80.30', 'A bela e a fera', 'DESPESA', '1', '1');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `type`, `category_id`, `person_id`)
VALUES ('Apostas', '2019-04-26', '2019-04-26', '312.47', 'RECEITA', '5', '3');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `type`, `category_id`, `person_id`)
VALUES ('Venda de Tapetes', '2019-05-29', '2019-05-29', '300.15', 'RECEITA', '5', '3');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `obs`, `type`, `category_id`, `person_id`)
VALUES ('Netflix', '2019-06-03', '2019-06-03', '48.60', 'Plano Premium', 'DESPESA', '1', '3');
INSERT INTO `launch` (`description`, `due_date`, `payment_date`, `value`, `type`, `category_id`, `person_id`)
VALUES ('Açougue', '2019-06-05', '2019-06-05', '420.86', 'DESPESA', '3', '3');
INSERT INTO launch (description, due_date, payment_date, value, obs, type, category_id, person_id)
VALUES ('Reforma Garagem', '2020-06-08', '2020-08-03', 1236.65, 'Piso Quebrado e troca do telhado', 'DESPESA', 2, 4);
INSERT INTO launch (description, due_date, payment_date, value, obs, type, category_id, person_id)
VALUES ('Venda Carro', '2020-07-05', '2020-07-13', 32000.00, 'Venda para cobrir gastos de reformas', 'RECEITA', 7, 7);