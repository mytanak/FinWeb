-- Carga do sistema
--Usuarios
SET IDENTITY_INSERT Usuario ON
INSERT INTO Usuario(codUsuario, idUsuario,nome,senha,email,dataNascimento)
VALUES(-1,'Admin','Administrador','21232F297A57A5A743894A0E4A801FC3','',null); -- senha admin
SET IDENTITY_INSERT Usuario ON

INSERT INTO Usuario(idUsuario,nome,senha,email,dataNascimento)
VALUES('Usuario1','Usuario 1 - Teste','122B738600A0F74F7C331C0EF59BC34C','',null); -- senha usuario1

INSERT INTO Usuario(idUsuario,nome,senha,email,dataNascimento) -- senha usuario2
VALUES('Usuario2','Usuario 2 - Teste','2FB6C8D2F3842A5CEAA9BF320E649FF0','',null);

--Contas
INSERT INTO Conta(codUsuario,descricao,saldoInicial)
SELECT codUsuario,
       'Conta1',
       0
FROM Usuario(NOLOCK);

INSERT INTO Conta(codUsuario,descricao,saldoInicial)
SELECT codUsuario,
       'Conta2',
       100
FROM Usuario(NOLOCK);

--Fornecedores
INSERT INTO Fornecedor(nome)
VALUES('Fornecedor1');

INSERT INTO Fornecedor(nome)
VALUES('Fornecedor2');

INSERT INTO Fornecedor(nome)
VALUES('Fornecedor3');

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

--Lancamento

DECLARE @codConta      Integer,
        @codFornecedor Integer,
        @codModalidade Integer,
        @codOperacao   Integer,
        @Fator          Numeric(18,2),
        @codModalidade_aux Integer,
        @dataPrevista      DateTime;
       
DECLARE Lancamento_Cursor Cursor
For
SELECT codConta,
       codFornecedor,
       codModalidade,
       codOperacao
FROM Conta(NOLOCK)
CROSS JOIN Fornecedor(NOLOCK)
CROSS JOIN Modalidade(NOLOCK)
CROSS JOIN Operacao(NOLOCK)


OPEN Lancamento_Cursor
FETCH NEXT FROM Lancamento_Cursor 
INTO @codConta,
     @codFornecedor,
     @codModalidade,
     @codOperacao;

SELECT @Fator = 1,
       @codModalidade_aux = 0;

WHILE @@FETCH_STATUS = 0
BEGIN
SELECT @Fator = RAND() * 1000;

IF (@codModalidade_aux <> @codModalidade)
BEGIN
  SELECT @codModalidade_aux = @codModalidade,
         @dataPrevista      = DATEADD(mm,1,GETDATE());
END
ELSE
BEGIN
  SET @dataPrevista = DATEADD(dd,5,GETDATE());
END

INSERT INTO Lancamento(codConta,codFornecedor,codModalidade,codOperacao,dataVencimento,dataRealizada,valor,observacao)
SELECT @codConta,
     @codFornecedor,
     @codModalidade,
     @codOperacao,
     @dataPrevista,
     NULL,
     ROUND(@Fator,2),
     '';
FETCH NEXT FROM Lancamento_Cursor 
INTO @codConta,
     @codFornecedor,
     @codModalidade,
     @codOperacao;

END
CLOSE Lancamento_Cursor
DEALLOCATE Lancamento_Cursor

