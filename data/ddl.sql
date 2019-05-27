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
   team_a VARCHAR NOT NULL ,
   team_b VARCHAR NOT NULL ,
   venu VARCHAR NOT NULL,
   match_status VARCHAR(250);
   match_result VARCHAR(250),
   match_summary VARCHAR(250),
   bet INTEGER NOT NULL,
   game_time TIMESTAMP NOT NULL ,
   game_date DATE
);


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

CREATE TABLE prediction (
   id INTEGER NOT NULL PRIMARY KEY,
   user_id INTEGER NOT NULL,
   fixture_id INTEGER NOT NULL,
   prediction_team INTEGER NOT NULL,
   win BOOLEAN,
   active BOOLEAN,
   prize_amount INTEGER NOT NULL,
   CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users (id),
   CONSTRAINT fixture_fk FOREIGN KEY (fixture_id) REFERENCES fixture (id)
);

ALTER TABLE public.prediction
    ADD COLUMN super_player INTEGER;

ALTER TABLE prediction
    ADD CONSTRAINT player_fk FOREIGN KEY (super_player) REFERENCES player (id);