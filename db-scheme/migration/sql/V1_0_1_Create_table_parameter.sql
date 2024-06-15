CREATE TABLE IF NOT EXISTS public."parameter" (
	id uuid NOT NULL,
	"name" varchar(255) NOT NULL,
	value varchar(255) NOT NULL,
    descrition varchar(500) NULL,
	CONSTRAINT parameter_pk PRIMARY KEY (id)
);