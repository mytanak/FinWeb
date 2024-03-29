begin tran
USE ProjetoWebJava
GO
/****** Object:  ForeignKey FK_Conta_Usuario    Script Date: 10/09/2011 19:23:03 ******/
IF EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Conta_Usuario') AND parent_object_id = OBJECT_ID(N'dbo.Conta'))
ALTER TABLE dbo.Conta DROP CONSTRAINT FK_Conta_Usuario; 
GO
/****** Object:  ForeignKey FK_Lancamento_Conta    Script Date: 10/09/2011 19:23:03 ******/
IF EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Conta') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento  DROP CONSTRAINT FK_Lancamento_Conta;
GO
/****** Object:  ForeignKey FK_Lancamento_Fornecedor    Script Date: 10/09/2011 19:23:03 ******/
IF EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Fornecedor') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento  DROP CONSTRAINT FK_Lancamento_Fornecedor;
GO
/****** Object:  ForeignKey FK_Lancamento_Modalidade    Script Date: 10/09/2011 19:23:03 ******/
IF EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Modalidade') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento DROP CONSTRAINT FK_Lancamento_Modalidade;
GO
/****** Object:  ForeignKey FK_Lancamento_Operacao    Script Date: 10/09/2011 19:23:03 ******/
IF EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Operacao') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento DROP CONSTRAINT FK_Lancamento_Operacao;
GO
/****** Object:  ForeignKey FK_Operacao_Grupo    Script Date: 10/09/2011 19:23:03 ******/
IF EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Operacao_Grupo') AND parent_object_id = OBJECT_ID(N'dbo.Operacao'))
ALTER TABLE dbo.Operacao DROP CONSTRAINT FK_Operacao_Grupo;
GO
/****** Object:  Table dbo.Modalidade    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Modalidade') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Modalidade;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Modalidade') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Modalidade(
	codModalidade int identity(1,1) NOT NULL,
	descricao varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT PK_Modalidade PRIMARY KEY CLUSTERED 
(
	codModalidade ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table dbo.Grupo    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Grupo') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Grupo;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Grupo') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Grupo(
	codGrupo int identity(1,1) NOT NULL,
	descricao varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT PK_Grupo PRIMARY KEY CLUSTERED 
(
	codGrupo ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table dbo.Fornecedor    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Fornecedor') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Fornecedor;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Fornecedor') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Fornecedor(
	codFornecedor int identity(1,1) NOT NULL,
	nome varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT PK_Fornecedor PRIMARY KEY CLUSTERED 
(
	codFornecedor ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table dbo.Usuario    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Usuario') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Usuario;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Usuario') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Usuario(
	codUsuario int identity(1,1) NOT NULL,
	idUsuario varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	nome varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	senha nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	email varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	dataNascimento datetime,
 CONSTRAINT PK_Usuario PRIMARY KEY CLUSTERED 
(
	codUsuario ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table dbo.Operacao    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Operacao') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Operacao;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Operacao') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Operacao(
	codOperacao int identity(1,1) NOT NULL,
	codGrupo int NOT NULL,
	descricao varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	tipo char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT PK_Operacao PRIMARY KEY CLUSTERED 
(
	codOperacao ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table dbo.Conta    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Conta') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Conta;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Conta') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Conta(
	codConta int identity(1,1) NOT NULL,
	codUsuario int NOT NULL,
	descricao varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	saldoInicial numeric(18, 2) NOT NULL,
 CONSTRAINT PK_Conta PRIMARY KEY CLUSTERED 
(
	codConta ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table dbo.Lancamento    Script Date: 10/09/2011 19:23:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Lancamento') AND type in (N'U'))
BEGIN
DROP TABLE dbo.Lancamento;
END
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Lancamento') AND type in (N'U'))
BEGIN
CREATE TABLE dbo.Lancamento(
	nroLancamento int identity(1,1) NOT NULL,
	codConta int NOT NULL,
	codOperacao int NOT NULL,
	codModalidade int NOT NULL,
	codFornecedor int NOT NULL,
	dataVencimento datetime NOT NULL,
	dataRealizada datetime,
	valor numeric(18, 2) NOT NULL,
	observacao varchar(500) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT PK_Lancamento PRIMARY KEY CLUSTERED 
(
	nroLancamento ASC
));
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey FK_Conta_Usuario    Script Date: 10/09/2011 19:23:03 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Conta_Usuario') AND parent_object_id = OBJECT_ID(N'dbo.Conta'))
ALTER TABLE dbo.Conta  WITH CHECK ADD  CONSTRAINT FK_Conta_Usuario FOREIGN KEY(codUsuario)
REFERENCES dbo.Usuario (codUsuario)
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Conta_Usuario') AND parent_object_id = OBJECT_ID(N'dbo.Conta'))
ALTER TABLE dbo.Conta CHECK CONSTRAINT FK_Conta_Usuario
GO
/****** Object:  ForeignKey FK_Lancamento_Conta    Script Date: 10/09/2011 19:23:03 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Conta') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento  WITH CHECK ADD  CONSTRAINT FK_Lancamento_Conta FOREIGN KEY(codConta)
REFERENCES dbo.Conta (codConta)
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Conta') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento CHECK CONSTRAINT FK_Lancamento_Conta
GO
/****** Object:  ForeignKey FK_Lancamento_Fornecedor    Script Date: 10/09/2011 19:23:03 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Fornecedor') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento  WITH CHECK ADD  CONSTRAINT FK_Lancamento_Fornecedor FOREIGN KEY(codFornecedor)
REFERENCES dbo.Fornecedor (codFornecedor)
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Fornecedor') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento CHECK CONSTRAINT FK_Lancamento_Fornecedor
GO
/****** Object:  ForeignKey FK_Lancamento_Modalidade    Script Date: 10/09/2011 19:23:03 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Modalidade') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento  WITH CHECK ADD  CONSTRAINT FK_Lancamento_Modalidade FOREIGN KEY(codModalidade)
REFERENCES dbo.Modalidade (codModalidade)
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Modalidade') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento CHECK CONSTRAINT FK_Lancamento_Modalidade
GO
/****** Object:  ForeignKey FK_Lancamento_Operacao    Script Date: 10/09/2011 19:23:03 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Operacao') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento  WITH CHECK ADD  CONSTRAINT FK_Lancamento_Operacao FOREIGN KEY(codOperacao)
REFERENCES dbo.Operacao (codOperacao)
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Lancamento_Operacao') AND parent_object_id = OBJECT_ID(N'dbo.Lancamento'))
ALTER TABLE dbo.Lancamento CHECK CONSTRAINT FK_Lancamento_Operacao
GO
/****** Object:  ForeignKey FK_Operacao_Grupo    Script Date: 10/09/2011 19:23:03 ******/
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Operacao_Grupo') AND parent_object_id = OBJECT_ID(N'dbo.Operacao'))
ALTER TABLE dbo.Operacao  WITH CHECK ADD  CONSTRAINT FK_Operacao_Grupo FOREIGN KEY(codGrupo)
REFERENCES dbo.Grupo (codGrupo)
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'dbo.FK_Operacao_Grupo') AND parent_object_id = OBJECT_ID(N'dbo.Operacao'))
ALTER TABLE dbo.Operacao CHECK CONSTRAINT FK_Operacao_Grupo
GO
rollback tran