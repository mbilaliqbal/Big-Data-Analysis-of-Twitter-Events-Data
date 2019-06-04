invalidate metadata;

create view if not exists teams_games_played
as
select fc.id, count (*) NumberofGames from fc, game
where fc.id=game.fc1 or fc.id=game.fc2
group by fc.id
order by NumberofGames desc;

select teams_games_played.id as TeamID, teams_games_played.numberofgames, count(distinct tweet_id)/teams_games_played.numberofgames count from 
tweets_consolidated, teams_games_played, game
where
tweets_consolidated.hashtag_id=teams_games_played.id and (unix_timestamp(tweets_consolidated.created) between unix_timestamp(game.officialstart) and unix_timestamp(game.officialend))
group by
TeamID, numberofgames
order by
count desc;
