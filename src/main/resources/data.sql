-- insere usuarios
insert into users (username, password_hash)
 values ('admin', '$2y$12$5EdmLUOPRT4DyMqA6s7qWe8jjWfLAtXfFsZuU8O5PFiaHOqUi/aMS'),
        ('comum', '$2y$12$5EdmLUOPRT4DyMqA6s7qWe8jjWfLAtXfFsZuU8O5PFiaHOqUi/aMS');

insert into perfis values (1, 'ADMIN'), (2, 'USUARIO');

-- insere clientes

insert into cliente (cpf, nome)
    values ('00640555152', 'Lucas Veiga Garcia'), ('11330449134', 'Arthur Marreira Ribeiro');

insert into email (email, id_cliente)
    values ('lucasveiga09@gmail.com', 1), ('arthurrib@gmail.com', 2), ('arthurito@gmail.com', 2);

insert into telefone (numero, tipo, id_cliente)
    values ('61998787528', 'CELULAR', 1), ('61992146359', 'CELULAR', 2), ('61998783775', 'CELULAR', 2);

insert into endereco (cep, logradouro, bairro, cidade, uf, id_cliente)
    values ('73015403', 'Quadra 2 Conj D3 Casa 4A', 'Sobradinho I', 'Brasilia', 'DF', 1),
        ('73015403', 'Edificio Casa de Sao Paulo', 'SBS', 'Brasilia', 'DF', 2);
