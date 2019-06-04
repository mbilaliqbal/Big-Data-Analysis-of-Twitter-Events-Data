invalidate metadata;

--This tweets consolidated table keeps tweets with unofficial hashtag
create table if not exists tweets_consolidated2
as
select a.tweet_id, b.user_id, b.created, a.hashtag_id 

from tweet_hashtag as a full join tweets_during_game_table as b 

on a.tweet_id =b.id;


--Restrict to tweets during the game

create view if not exists tweets_during_game
as
select tweet_id, hashtag_id from 
tweets_consolidated2, game
where tweets_consolidated2.created between game.officialstart and game.officialend;



--Filter out tweets with official hashtags
create view if not exists tweets_during_game2
as
select * from tweets_during_game where hashtag_id>22;


create view if not exists pre_top_nonofficial_hashtags
as
select distinct(tweet_id), hashtag_id counts from tweets_during_game2;


--count occurrence of all unofficial hashtags
create view if not exists top_nonofficial_hashtags
as
select counts hashtagID, count(counts) counts from pre_top_nonofficial_hashtags group by hashtagID order by counts desc limit 10;



select hashtag.id, hashtag.hashtag, counts from hashtag, top_nonofficial_hashtags
where hashtag.id=hashtagid group by hashtag.id, hashtag.hashtag, counts order by counts desc;

