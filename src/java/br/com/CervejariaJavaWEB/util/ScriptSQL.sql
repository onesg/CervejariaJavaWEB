--  SCRIPT SQL

--  NOME DO BANCO: CervejariaJavaWEB

--  CRIAÇÃO DA TABELA cliente
CREATE TABLE IF NOT EXISTS cliente(
   id_cliente		SERIAL		NOT NULL,	-- 
   nome_cliente		VARCHAR(64)	NOT NULL,	-- 
   email_cliente	VARCHAR(64)	NOT NULL,	-- 
   telefone_cliente	VARCHAR(64),			-- NAO FORMATADO
   login_cliente	VARCHAR(64)	NOT NULL,	-- 
   senha_cliente	VARCHAR(64)	NOT NULL,	--
   CONSTRAINT pk_id_client PRIMARY KEY(id_cliente)
);

--  LISTANDO TABELA cliente
SELECT * FROM cliente;


--  CRIAÇÃO DA TABELA fornecedor
CREATE TABLE IF NOT EXISTS fornecedor(
   id_fornecedor		SERIAL		NOT NULL,	-- 
   cnpj_fornecedor		VARCHAR(64)	NOT NULL,	-- NAO FORMATADO
   razao_social_fornecedor	VARCHAR(64)	NOT NULL,	-- 
   email_fornecedor		VARCHAR(64)	NOT NULL,	-- 
   telefone_fornecedor		VARCHAR(64),			-- NAO FORMATADO
   endereco_fornecedor		VARCHAR(64)	NOT NULL,	-- NAO FORMATADO
   cidade_fornecedor		VARCHAR(64)	NOT NULL,	-- NAO FORMATADO
   estado_fornecedor		VARCHAR(64)	NOT NULL,	-- NAO FORMATADO
   CONSTRAINT pk_id_fornecedor PRIMARY KEY(id_fornecedor)
);

--  LISTANDO TABELA fornecedor
SELECT * FROM fornecedor;


--  CRIAÇÃO DA TABELA categoria
CREATE TABLE IF NOT EXISTS categoria(
   id_categoria		SERIAL		NOT NULL,	-- 
   nome_categoria	VARCHAR(64)	NOT NULL,	-- 
   descricao_categoria	VARCHAR(64),			-- 
   CONSTRAINT pk_id_categoria PRIMARY KEY(id_categoria)
);

--  LISTANDO TABELA categoria
SELECT * FROM categoria;


--  CRIAÇÃO DA TABELA admin_user
CREATE TABLE IF NOT EXISTS admin_user(
   id_admin_user	SERIAL		NOT NULL,	-- 
   login_admin_user	VARCHAR(64)	NOT NULL,	-- 
   senha_admin_user	VARCHAR(64)	NOT NULL,	-- 
   CONSTRAINT pk_id_admin_user PRIMARY KEY(id_admin_user)
);

--  LISTANDO TABELA admin_user
SELECT * FROM admin_user;

