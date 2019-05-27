INSERT INTO public.users(
	id, first_name, last_name, email, password, dob, gender)
	VALUES (1, 'test', 'user', 'test@email.com','1234','2019-05-27', 'M');

INSERT INTO public.team(
	id, name)
	VALUES (1, ''),
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
	id, team_a, team_b, venu, game_time, game_date)
	VALUES (1, 4, 1, 'Kennington Oval,Londoan', '2019-05-27 15:00:00', '2019-05-27'),
	(2, 5, 3, 'Sophia Gardens,Cardiff', '2019-05-28 15:00:00', '2019-05-28'),
	(3, 4, 8, 'Kennington Oval,Londoan', '2019-05-30 15:00:00', '2019-05-30');

