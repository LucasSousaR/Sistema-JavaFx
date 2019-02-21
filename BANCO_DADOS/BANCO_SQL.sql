/* Diagrama L�gico- scte: */

CREATE TABLE pessoa (
    in_pv_id  serial not null PRIMARY KEY,
    st_pv_nome VARCHAR(50) not null,
    st_pv_cpf VARCHAR(12) not null,
    st_pv_rg VARCHAR(11)not null,
    st_pv_telefone VARCHAR(11),
    st_pv_telefone_celular VARCHAR(12) not null
    
);

CREATE TABLE endereco (
   in_pv_id  serial not null PRIMARY KEY,
    st_pv_endereco VARCHAR(60) not null,
    in_pv_numEndereco numeric(6,0),
    st_pv_complemento VARCHAR(25) not null,
    st_pv_bairro VARCHAR(30)not null,
    st_pv_CEP VARCHAR(9),
    st_pv_cidade VARCHAR(12) not null    
    
);


CREATE TABLE enderecoPessoa (
     in_pv_id  serial not null PRIMARY KEY,
    in_pv_id_pessoa integer not null,
    in_pv_id_endereco integer not null
    
);



CREATE TABLE administrador (
     in_pv_id  integer not null PRIMARY KEY,
    st_pv_login VARCHAR(12) not null,
    st_pv_senha VARCHAR(7)not null

);

CREATE TABLE atendente (
    in_pv_id integer not null PRIMARY KEY,
    st_pv_login varchar(12)not null,
    st_pv_senha varchar(7) not nullpessoa 
);


CREATE TABLE convenio (
     in_pv_id  serial not null PRIMARY KEY,
    st_pv_nome VARCHAR(20) not null
);


CREATE TABLE cliente (
    in_pv_id  integer not null PRIMARY KEY,
    in_pv_id_convenio integer not null
);

CREATE TABLE Dependente (
    in_pv_id  serial not null PRIMARY KEY,
    st_pv_nome VARCHAR(50) not null,
    st_pv_cpf VARCHAR(12) not null,
    st_pv_rg VARCHAR(11)not null,
    st_pv_telefone_celular VARCHAR(12) not null
);



CREATE TABLE DependenteCliente (
   in_pv_id  serial not null PRIMARY KEY ,
    in_pv_id_cliente integer not null,
    in_pv_id_dependente integer not null
    
     
);


CREATE TABLE procedimentoEstetico (
    in_pv_id  serial not null PRIMARY KEY,
	st_pv_nome VARCHAR(50) not null,
	st_pv_descricao VARCHAR(151) not null,
	fl_pv_valor decimal(10,2) not null
);


CREATE TABLE profissionalEstetico (
    in_pv_id  integer not null PRIMARY KEY
    
    
);

CREATE TABLE procedimentoProfissional (
    in_pv_id  serial not null PRIMARY KEY,
    in_pv_id_procedimento integer not null,
    in_pv_id_profissional integer not null
);

CREATE TABLE diaAgendado (
    in_pv_id  serial not null PRIMARY KEY,
    dt_pv_data varchar(11)  not null,
    fm_pv_hora varchar(9)  not null,
    in_pv_id_cliente integer not null,
    in_pv_id_procedimento integer not null,
    in_pv_id_profissional integer not null
   
);



   
	ALTER TABLE enderecoPessoa ADD CONSTRAINT FK_in_pv_id_pessoa 
            FOREIGN KEY (in_pv_id_pessoa)
			REFERENCES pessoa (in_pv_id);
            
    ALTER TABLE enderecoPessoa ADD CONSTRAINT FK_in_pv_id_endereco
           FOREIGN KEY (in_pv_id_endereco)
			REFERENCES endereco (in_pv_id);


    ALTER TABLE cliente ADD CONSTRAINT FK_in_pv_id 
            FOREIGN KEY (in_pv_id)
			REFERENCES pessoa (in_pv_id);
     ALTER TABLE cliente ADD CONSTRAINT FK_in_pv_id_convenio 
            FOREIGN KEY (in_pv_id_convenio)
			REFERENCES convenio (in_pv_id);



    ALTER TABLE DependenteCliente ADD CONSTRAINT FK_in_pv_id_cliente 
            FOREIGN KEY (in_pv_id_cliente)
			REFERENCES pessoa (in_pv_id);
     ALTER TABLE DependenteCliente ADD CONSTRAINT FK_in_pv_id_dependente   
            FOREIGN KEY (in_pv_id_dependente)
	        REFERENCES dependente (in_pv_id);


    ALTER TABLE administrador ADD CONSTRAINT FK_in_pv_id 
            FOREIGN KEY (in_pv_id)
			REFERENCES pessoa (in_pv_id);


    ALTER TABLE profissionalEstetico ADD CONSTRAINT FK_in_pv_id
            FOREIGN KEY (in_pv_id)
			REFERENCES pessoa (in_pv_id);


    ALTER TABLE procedimentoProfissional ADD CONSTRAINT FK_in_pv_id_procedimento 
            FOREIGN KEY (in_pv_id_procedimento)
			REFERENCES procedimentoEstetico (in_pv_id);
	ALTER TABLE procedimentoProfissional ADD CONSTRAINT FK_in_pv_id_profissional 
            FOREIGN KEY (in_pv_id_profissional)
			REFERENCES profissionalEstetico (in_pv_id);
			

    ALTER TABLE diaAgendado ADD CONSTRAINT FK_in_pv_id_cliente 
            FOREIGN KEY (in_pv_id_cliente)
			REFERENCES cliente (in_pv_id);			 
   ALTER TABLE diaAgendado ADD CONSTRAINT FK_in_pv_id_procedimento 
        FOREIGN KEY (in_pv_id_procedimento)
        REFERENCES procedimentoEstetico (in_pv_id);    
   ALTER TABLE diaAgendado ADD CONSTRAINT FK_in_pv_id_profissional 
        FOREIGN KEY (in_pv_id_profissional)
        REFERENCES profissionalEstetico (in_pv_id);

    