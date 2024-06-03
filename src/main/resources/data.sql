INSERT INTO customer (id_customer, name, email) VALUES
(1,'Mariazinha', 'mariazinha@email.com'),
(2,'Joãozinho', 'joaozinho@email.com');

INSERT INTO address (id_address, street, number, neighborhood, city, cep, address_type, customer_id) VALUES
(1, 'Rua A', 100, 'Bairro A', 'Cidade A', '00000000', 'PRINCIPAL', 1),
(2, 'Rua B', 200, 'Bairro B', 'Cidade B', '11111111', 'SECUNDARIO', 1),
(3, 'Rua C', 300, 'Bairro C', 'Cidade C', '22222222', 'PRINCIPAL', 2),
(4, 'Rua D', 400, 'Bairro D', 'Cidade D', '33333333', 'SECUNDARIO', 2);