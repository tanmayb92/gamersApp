insert into game(game_genre,game_name,game_type,release_year) values ('sports','fifa','multiplayer','2022');
insert into game(game_genre,game_name,game_type,release_year) values ('FPS','CS','multiplayer','2010');
insert into game(game_genre,game_name,game_type,release_year)  values ('FPS','Valorant','multiplayer','2022');
insert into game(game_genre,game_name,game_type,release_year)  values ('RPG','God of War','singleplayer','2022');


insert into skill(level) values ('PRO');
insert into skill(level) values ('NOOB');
insert into skill(level) values ('INVINCIBLE');



insert into country(country_code,country_name,geo) values ('DK','Denmark','Europe');
insert into country(country_code,country_name,geo) values ('NL','Netherlands','Europe');
insert into country(country_code,country_name,geo) values ('IN','India','Asia');



insert into gamer(name,email,gender,date_of_birth,creation_date,country_id) values ('logan','logan@gmail.com','Male','1992-10-11','2022-02-02',1L);
insert into gamer(name,email,gender,date_of_birth,creation_date,country_id) values ('logan123','logan123@gmail.com','Male','1995-10-11','2022-02-04',1L);

insert into gamers_game(user_name,game_id,gamer_id,skill_id) values('noobmaster',1L,1L,1L);

insert into gamers_game(user_name,game_id,gamer_id,skill_id) values('noobmaster123',2L,2L,1L);
