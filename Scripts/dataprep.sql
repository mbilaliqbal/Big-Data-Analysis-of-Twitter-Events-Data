invalidate metadata;

--Creating tweets during game table
create table if not exists tweets_during_game_table 
as
select distinct tweet.id, tweet.created, tweet.user_id from tweet, game
where tweet.created between game.officialstart and game.officialend;

--Restricting hashtags to the official hashtag
create table if not exists tweet_hashtag_official_table 
as
select tweet_hashtag.tweet_id, tweet_hashtag.hashtag_id from tweet_hashtag 
where tweet_hashtag.hashtag_id > 0 and tweet_hashtag.hashtag_id<23;

--create a consolidated tweet table
create table if not exists tweets_consolidated
as
select a.tweet_id, b.user_id, b.created, a.hashtag_id 

from tweets_during_game_table b 

join tweet_hashtag_official_table a

where a.tweet_id =b.id;
