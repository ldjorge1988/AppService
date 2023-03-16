CREATE TABLE IF NOT EXISTS user (
                      id bigint NOT NULL AUTO_INCREMENT,
                      identification character varying(50) NOT NULL,
                      name character varying(50) NOT NULL,
                      user_name character varying(50) NOT NULL,
                      password character varying(50) NOT NULL,
                      email character varying(50) NOT NULL,
                      CONSTRAINT user_pkey PRIMARY KEY (id)
);
