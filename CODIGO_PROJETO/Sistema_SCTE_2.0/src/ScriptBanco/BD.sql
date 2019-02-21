﻿


CREATE TABLE public."pessoa" (

    in_pv_id  serial not null,
    st_pv_nome VARCHAR(50) not null,
    st_pv_cpf VARCHAR(12) not null,
    st_pv_rg VARCHAR(11)not null,
    st_pv_telefone VARCHAR(11),
    st_pv_telefone_celular VARCHAR(12) not null,
    
    
    CONSTRAINT "pessoa_pkey" PRIMARY KEY ("in_pv_id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."pessoa"
    OWNER to postgres;
    


CREATE TABLE public."endereco" (
    in_pv_id  serial not null,
    st_pv_endereco VARCHAR(60) not null,
    in_pv_numEndereco numeric(6,0),
    st_pv_complemento VARCHAR(25) not null,
    st_pv_bairro VARCHAR(30)not null,
    st_pv_CEP VARCHAR(9),
    st_pv_cidade VARCHAR(12) not null,    
    
    CONSTRAINT "endereco_pkey" PRIMARY KEY ("in_pv_id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."endereco"
    OWNER to postgres;
    


CREATE TABLE public."enderecoPessoa" (
    in_pv_id  serial not null,
    in_pv_id_pessoa integer not null,
    in_pv_id_endereco integer not null,
    
    
    CONSTRAINT "enderecoPessoa_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_pessoa" FOREIGN KEY ("in_pv_id_pessoa")
			REFERENCES public."pessoa" ("in_pv_id"), 
	CONSTRAINT "FK_in_pv_id_endereco" FOREIGN KEY ("in_pv_id_endereco")
			REFERENCES public."endereco" ("in_pv_id")     
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."enderecoPessoa"
    OWNER to postgres;
    



CREATE TABLE public."convenio" (
    in_pv_id  serial not null,
    st_pv_nome VARCHAR(20) not null,

    CONSTRAINT "convenio_pkey" PRIMARY KEY ("in_pv_id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."convenio"
    OWNER to postgres;






CREATE TABLE public."cliente" (

    in_pv_id  integer not null,
    in_pv_id_convenio integer not null,

    
    CONSTRAINT "cliente_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id" FOREIGN KEY ("in_pv_id")
        REFERENCES public."pessoa" ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_convenio" FOREIGN KEY ("in_pv_id_convenio")
	REFERENCES public."convenio" ("in_pv_id") 	
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."cliente"
    OWNER to postgres;
    
    
 
CREATE TABLE public."dependente" (

    in_pv_id  serial not null,
    st_pv_nome VARCHAR(50) not null,
    st_pv_cpf VARCHAR(12) not null,
    st_pv_rg VARCHAR(11)not null,
    st_pv_telefone_celular VARCHAR(12) not null,
    
    CONSTRAINT "dependente_pkey" PRIMARY KEY ("in_pv_id")
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."dependente"
    OWNER to postgres;
       
    
    
    
    
CREATE TABLE public."DependenteCliente" (
    in_pv_id  serial not null,
    in_pv_id_cliente integer not null,
    in_pv_id_dependente integer not null,
    

    CONSTRAINT "DependenteCliente_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_cliente" FOREIGN KEY ("in_pv_id_cliente")
			REFERENCES public."cliente" ("in_pv_id"), 
	CONSTRAINT "FK_in_pv_id_dependente" FOREIGN KEY ("in_pv_id_dependente")
			REFERENCES public."dependente" ("in_pv_id")       
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DependenteCliente"
    OWNER to postgres;
    
    
    


CREATE TABLE public."administrador" (

    in_pv_id  integer not null,
    st_pv_login VARCHAR(12) not null,
    st_pv_senha VARCHAR(7)not null,

    
    CONSTRAINT "administrador_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id" FOREIGN KEY ("in_pv_id")
        REFERENCES public."pessoa" ("in_pv_id")	
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."administrador"
    OWNER to postgres;



    
    
CREATE TABLE public."profissionalEstetico" (

    in_pv_id  integer not null,
    
    
    
    CONSTRAINT "profissionalEstetico_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id" FOREIGN KEY ("in_pv_id")
        REFERENCES public."pessoa" ("in_pv_id")

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."profissionalEstetico"
    OWNER to postgres;
    
    
CREATE TABLE public."procedimentoEstetico" (

        in_pv_id  serial not null,
	st_pv_nome VARCHAR(50) not null,
	st_pv_descricao VARCHAR(151) not null,
	fl_pv_valor decimal(10,2) not null,
    
    CONSTRAINT "procedimentoEstetico_pkey" PRIMARY KEY ("in_pv_id")

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."procedimentoEstetico"
    OWNER to postgres;





CREATE TABLE public."procedimentoProfissional" (
    in_pv_id  serial not null,
    in_pv_id_procedimento integer not null,
    in_pv_id_profissional integer not null,
    
    
    CONSTRAINT "procedimentoProfissiona_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_procedimento" FOREIGN KEY ("in_pv_id_procedimento")
        REFERENCES public."procedimentoEstetico" ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_profissional" FOREIGN KEY ("in_pv_id_profissional")
        REFERENCES public."profissionalEstetico" ("in_pv_id")
   
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."procedimentoProfissional"
    OWNER to postgres;
    
    
    
CREATE TABLE public."diaAgendado" (

    in_pv_id  serial not null,
    dt_pv_data date not null,  ---mysql usa  DateTime
    fm_pv_hora time  not null,
    in_pv_id_cliente integer not null,
    in_pv_id_procedimento integer not null,
    in_pv_id_profissional integer not null,

    
    CONSTRAINT "diaAgendado_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_cliente" FOREIGN KEY ("in_pv_id_cliente")
			REFERENCES public."cliente" ("in_pv_id"),
			 
   CONSTRAINT "FK_in_pv_id_procedimento" FOREIGN KEY ("in_pv_id_procedimento")
        REFERENCES public."procedimentoEstetico" ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id_profissional" FOREIGN KEY ("in_pv_id_profissional")
        REFERENCES public."profissionalEstetico" ("in_pv_id")
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."diaAgendado"
    OWNER to postgres;
    