CREATE TABLE IF NOT EXISTS user (
                                    id bigint NOT NULL,
                                    identification character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    user_name character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    status character varying(30),
    CONSTRAINT user_pkey PRIMARY KEY (id)
    );

CREATE SEQUENCE IF NOT EXISTS user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE user_id_seq OWNED BY user.id;
ALTER TABLE ONLY user ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);
SELECT pg_catalog.setval('role_id_seq', 1, true);