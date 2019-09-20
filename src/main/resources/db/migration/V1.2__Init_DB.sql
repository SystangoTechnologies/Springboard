CREATE TABLE faq
(
  id serial NOT NULL,
  create_timestamp timestamp without time zone,
  last_edit_timestamp timestamp without time zone,
  answer character varying(255),
  question character varying(255),
  CONSTRAINT faq_pkey PRIMARY KEY (id)
);

CREATE TABLE wallet_details
(
  id serial NOT NULL,
  create_timestamp timestamp without time zone,
  last_edit_timestamp timestamp without time zone,
  wallet_level character varying(255),
  application_user_id bigint,
  CONSTRAINT wallet_details_pkey PRIMARY KEY (id),
  CONSTRAINT wallet_details_userid_fk FOREIGN KEY (application_user_id)
      REFERENCES public.application_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);