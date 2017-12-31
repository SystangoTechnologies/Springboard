--APPLICATION_USER
INSERT INTO APPLICATION_USER (id, create_timestamp, last_edit_timestamp, username, password, email, first_name, last_name, phone_number)
VALUES
  (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', '$2a$10$RyICQ69.sgW0JCsdSvwmu.iYuZ2vNyr5X7UpQjhayj.6WRL2KqnMO',
   'admin@sprinboard.com', 'super', 'admin', '9425094250');
INSERT INTO APPLICATION_USER (id, create_timestamp, last_edit_timestamp, username, password, email, first_name, last_name, phone_number)
VALUES (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user', '$2a$10$RyICQ69.sgW0JCsdSvwmu.iYuZ2vNyr5X7UpQjhayj.6WRL2KqnMO',
        'user@springboard.com', 'normal', 'user', '9425094251');

--ROLES
INSERT INTO ROLE (id, create_timestamp, last_edit_timestamp, name)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_ADMIN');
INSERT INTO ROLE (id, create_timestamp, last_edit_timestamp, name)
VALUES (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_USER');

--USER_ROLES
INSERT INTO USER_ROLES (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLES (user_id, role_id)
VALUES (2, 2);

--SETTINGS
--About
INSERT INTO SETTINGS (create_timestamp, last_edit_timestamp, setting_key, setting_value)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'about',
        'Springboard IS a Spring Boot starter - kit');

--Terms
INSERT INTO SETTINGS (create_timestamp, last_edit_timestamp, setting_key, setting_value)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'terms_and_conditions',
        'This is an OPEN - SOURCE project.');

--Privacy policy
INSERT INTO SETTINGS (create_timestamp, last_edit_timestamp, setting_key, setting_value)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'privacy_policy',
        ' NO terms AND conditions APPLY AT this TIME ');
