CREATE TABLE application_user
(
  id serial,
  create_timestamp timestamp without time zone,
  last_edit_timestamp timestamp without time zone,
  email character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  password character varying(255),
  phone_number character varying(255),
  username character varying(255),
  CONSTRAINT application_user_pkey PRIMARY KEY (id)
);

CREATE TABLE role
(
  id serial,
  create_timestamp timestamp without time zone,
  last_edit_timestamp timestamp without time zone,
  name character varying(255),
  CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  CONSTRAINT user_roles_userid_fk FOREIGN KEY (user_id)
      REFERENCES public.application_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_roles_roleid_fk FOREIGN KEY (role_id)
      REFERENCES public.role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE settings
(
  id serial,
  create_timestamp timestamp without time zone,
  last_edit_timestamp timestamp without time zone,
  setting_key character varying(255),
  setting_value character varying(255),
  CONSTRAINT settings_pkey PRIMARY KEY (id)
);

INSERT INTO APPLICATION_USER (username, password, email, first_name, last_name, phone_number)
VALUES
  ('admin', '$2a$10$RyICQ69.sgW0JCsdSvwmu.iYuZ2vNyr5X7UpQjhayj.6WRL2KqnMO',
   'admin@sprinboard.com', 'super', 'admin', '9425094250');
INSERT INTO APPLICATION_USER (username, password, email, first_name, last_name, phone_number)
VALUES ('user', '$2a$10$RyICQ69.sgW0JCsdSvwmu.iYuZ2vNyr5X7UpQjhayj.6WRL2KqnMO',
        'user@springboard.com', 'normal', 'user', '9425094251');

--ROLES
INSERT INTO ROLE (name)
VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name)
VALUES ('ROLE_USER');

--USER_ROLES
INSERT INTO USER_ROLES (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLES (user_id, role_id)
VALUES (2, 2);

--SETTINGS
--About
INSERT INTO SETTINGS (setting_key, setting_value)
VALUES ('about', 'Springboard IS a Spring Boot starter - kit');

--Terms
INSERT INTO SETTINGS (setting_key, setting_value)
VALUES ('terms_and_conditions', 'This is an OPEN - SOURCE project.');

--Privacy policy
INSERT INTO SETTINGS (setting_key, setting_value)
VALUES ('privacy_policy', ' NO terms AND conditions APPLY AT this TIME ');
