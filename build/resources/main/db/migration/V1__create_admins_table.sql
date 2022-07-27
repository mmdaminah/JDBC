CREATE TABLE IF NOT EXISTS Admin
(
    id integer NOT NULL DEFAULT nextval('"Admin_id_seq"'::regclass),
    first_name character varying(72) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(72) COLLATE pg_catalog."default" NOT NULL,
    username character varying(72) COLLATE pg_catalog."default" NOT NULL,
    password character varying(72) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(10) COLLATE pg_catalog."default" NOT NULL,
    creator integer,
    super_admin boolean NOT NULL,
    CONSTRAINT "Admin_pkey" PRIMARY KEY (id),
    CONSTRAINT "phone_number unique" UNIQUE (phone_number),
    CONSTRAINT "username unique" UNIQUE (username),
    CONSTRAINT "admin relation" FOREIGN KEY (creator)
        REFERENCES public."Admin" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

)