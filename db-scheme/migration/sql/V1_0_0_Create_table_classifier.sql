CREATE TABLE IF NOT EXISTS public.classifier (
	id uuid NOT NULL,
	"type" varchar(255) NOT NULL,
	value varchar(255) NOT NULL,
	CONSTRAINT classifier_pk PRIMARY KEY (id)
);