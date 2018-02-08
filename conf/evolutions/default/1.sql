# DC schema
 
# --- !Ups


CREATE TABLE customer (
  id              SERIAL NOT NULL PRIMARY KEY,
  firstname       VARCHAR(100) NOT NULL,
  lastname        VARCHAR(100) NOT NULL
);

 
# --- !Downs

DROP TABLE customer;