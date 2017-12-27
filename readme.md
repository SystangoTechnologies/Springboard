Steps to create the Database in Postgressql-
*CREATE ROLE springboarduser WITH LOGIN PASSWORD 'springboard';
*ALTER ROLE springboarduser CREATEDB; 
*CREATE DATABASE springboard_db;
*GRANT ALL PRIVILEGES ON DATABASE springboard_db TO springboarduser;