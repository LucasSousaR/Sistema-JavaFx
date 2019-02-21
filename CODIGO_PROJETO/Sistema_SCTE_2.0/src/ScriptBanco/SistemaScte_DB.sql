/* Diagrama Lógico- scte: */



CREATE TABLE public."dependente" (
    in_pv_id  serial not null,
    in_pv_id_convenio integer not null,

    
    
    CONSTRAINT "cliente_pkey" PRIMARY KEY ("in_pv_id"),
    
    CONSTRAINT "FK_in_pv_id_pessoa" FOREIGN KEY ("in_pv_id_pessoa"),
			REFERENCES public."pessoa" ("in_pv_id") 
	CONSTRAINT "FK_in_pv_id_endereco" FOREIGN KEY ("in_pv_id_endereco")
			REFERENCES public."endereco" ("in_pv_id") 
        
    
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
    
    
    
    CONSTRAINT "FK_in_pv_id_cliente" FOREIGN KEY ("in_pv_id_cliente"),
			REFERENCES public."cliente" ("in_pv_id") 
	CONSTRAINT "FK_in_pv_id_dependente" FOREIGN KEY ("in_pv_id_dependente")
			REFERENCES public."dependente" ("in_pv_id") 
        
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."DependenteCliente"
    OWNER to postgres;






