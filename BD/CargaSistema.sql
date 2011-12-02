-- Carga do sistema
--Usuarios
SET IDENTITY_INSERT Usuario ON
INSERT INTO Usuario(codUsuario, idUsuario,nome,senha,email,dataNascimento)
VALUES(-1,'Admin','Administrador','21232F297A57A5A743894A0E4A801FC3','',null); -- senha admin
SET IDENTITY_INSERT Usuario ON

--Modalidades
INSERT INTO Modalidade(descricao)
VALUES('Dinheiro');

INSERT INTO Modalidade(descricao)
VALUES('Cheque');

INSERT INTO Modalidade(descricao)
VALUES('Cartão de Crédito');

INSERT INTO Modalidade(descricao)
VALUES('Boleto Bancário');

INSERT INTO Modalidade(descricao)
VALUES('Débito em Conta');

--Grupos
INSERT INTO Grupo(descricao)
VALUES('Remuneração');

INSERT INTO Grupo(descricao)
VALUES('Outras Receitas');

INSERT INTO Grupo(descricao)
VALUES('Impostos');

INSERT INTO Grupo(descricao)
VALUES('Despesas Gerais');

INSERT INTO Grupo(descricao)
VALUES('Viagens');

INSERT INTO Grupo(descricao)
VALUES('Alimentação');

INSERT INTO Grupo(descricao)
VALUES('Moradia');

INSERT INTO Grupo(descricao)
VALUES('Educação');

INSERT INTO Grupo(descricao)
VALUES('Transporte');

--Operações
INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Salário',
       'C' -- Credito
FROM Grupo(NOLOCK)
WHERE descricao = 'Remuneração';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Venda de Veículo',
       'C' -- Credito
FROM Grupo(NOLOCK)
WHERE descricao = 'Outras Receitas';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'IPTU',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Impostos';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'IPVA',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Impostos';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Consumo de água',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Moradia';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Aluguel',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Moradia';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Consumo de Energia',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Moradia';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Telefone Fixo',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Moradia';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Restaurante',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Alimentação';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Padaria',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Alimentação';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Supermercado',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Alimentação';

INSERT INTO Operacao(codGrupo,descricao,tipo)
SELECT codGrupo,
       'Combustível',
       'D' -- Debito
FROM Grupo(NOLOCK)
WHERE descricao = 'Transporte';


