CREATE TABLE users(
    id integer NOT NULL,
    first_name VARCHAR (250) NOT NULL,
    last_name VARCHAR(250),
    email VARCHAR(250) NOT NULL,
    password VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    gender "char" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE team
(
    id integer NOT NULL,
    name VARCHAR (100) NOT NULL,
    CONSTRAINT team_pkey PRIMARY KEY (id)
);


CREATE TABLE fixture (
   id INTEGER NOT NULL PRIMARY KEY,
   team_a INTEGER NOT NULL ,
   team_b INTEGER NOT NULL ,
   venu VARCHAR NOT NULL,
   game_time TIMESTAMP NOT NULL ,
   game_date DATE,
   CONSTRAINT team_fk_1 FOREIGN KEY (team_a) REFERENCES team (id),
   CONSTRAINT team_fk_2 FOREIGN KEY (team_b) REFERENCES team (id)
);

ALTER TABLE public.fixture
    ADD COLUMN match_result VARCHAR(250);

ALTER TABLE public.fixture
    ADD COLUMN match_status VARCHAR(250);

ALTER TABLE public.fixture
    ADD COLUMN match_summary VARCHAR(250);


CREATE TABLE player (
   id INTEGER NOT NULL PRIMARY KEY,
   first_name VARCHAR NOT NULL,
   last_name VARCHAR NOT NULL,
   Age INTEGER ,
   team INTEGER NOT NULL ,
   playing BOOLEAN DEFAULT TRUE,
   captain BOOLEAN DEFAULT FALSE ,
   bats BOOLEAN DEFAULT FALSE,
   bowls BOOLEAN DEFAULT FALSE,
   wicket_keeper BOOLEAN DEFAULT FALSE,
   dob DATE,
   CONSTRAINT team_fk FOREIGN KEY (team) REFERENCES team (id)
);

CREATE TABLE predict_master (
   id INTEGER NOT NULL PRIMARY KEY,
   fixture_id INTEGER NOT NULL,
   prize_amount INTEGER NOT NULL,
   CONSTRAINT fixture_fk FOREIGN KEY (fixture_id) REFERENCES fixture (id)
);

CREATE TABLE prediction (
   id INTEGER NOT NULL PRIMARY KEY,
   prediction_master_id INTEGER ,
   user_id INTEGER NOT NULL,
   fixture_id INTEGER NOT NULL,
   prediction_team INTEGER NOT NULL,
   win BOOLEAN,
   active BOOLEAN,
   prize_amount INTEGER NOT NULL,
   CONSTRAINT prediction_master_fk FOREIGN KEY (prediction_master_id) REFERENCES predict_master (id),
   CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.user (id),
   CONSTRAINT fixture_fk FOREIGN KEY (fixture_id) REFERENCES fixture (id),
   CONSTRAINT prediction_fk FOREIGN KEY (prediction_team) REFERENCES team (id)

);