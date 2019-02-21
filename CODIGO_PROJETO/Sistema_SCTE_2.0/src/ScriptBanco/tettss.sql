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

    in_pv_id  serial not null,
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
    
    
   
   
   CREATE TABLE public."administrador" (

    in_pv_id  integer not null,
    in_pv_id_convenio integer not null,

    
    
    CONSTRAINT "administrador_pkey" PRIMARY KEY ("in_pv_id"),
    CONSTRAINT "FK_in_pv_id" FOREIGN KEY ("in_pv_id")
        REFERENCES public."pessoa" ("in_pv_id"),
        
    CONSTRAINT "FK_in_pv_id_convenio" FOREIGN KEY ("in_pv_id_convenio")
			REFERENCES public."convenio" ("in_pv_id") 
            
	
    
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."administrador"
    OWNER to postgres;
    
    