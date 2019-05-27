INSERT INTO public.users(
	id, first_name, last_name, email, password, dob, gender)
	VALUES (1, 'test', 'user', 'test@email.com','1234','2019-05-27', 'M');

INSERT INTO public.team(
	id, name)
	VALUES
	(1, 'Afghanistan'),
	(2, 'Australia'),
	(3, 'Bangladesh'),
	(4, 'England'),
	(5, 'India'),
	(6, 'New Zealand'),
	(7, 'Pakistan'),
	(8, 'South Africa'),
	(9, 'Sri Lanka'),
	(10, 'West Indies')
	;

INSERT INTO public.fixture(
	id, team_a, team_b, venu, match_status, bet, game_time, game_date)
	VALUES (1, 'ENGLAND', 'Afghanistan', 'Kennington Oval,Londoan', 'ONGOING',0, '2019-05-27 15:00:00', '2019-05-27'),
	(2, 'India', 'Bangladesh', 'Sophia Gardens, Cardiff', 'PENDING',0, '2019-05-28 15:00:00', '2019-05-28'),
	(3, 'ENGLAND', 'South Africa', 'Kennington Oval,Londoan', 'PENDING',100, '2019-05-30 15:00:00', '2019-05-30');


INSERT INTO public.player(
	id, first_name, last_name, age, team, playing, captain, bats, bowls, wicket_keeper, dob)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

INSERT INTO public.prediction(
	id, user_id, fixture_id, prediction_team, win, active, prize_amount)
	VALUES (?, ?, ?, ?, ?, ?, ?);

