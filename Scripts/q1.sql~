invalidate metadata;



create view if not exists games_with_tweet_counts
as
select game.id, game.officialstart, game.officialend,(count(distinct tweets_consolidated.tweet_id)) num_tweets from game join tweets_consolidated  
where
(tweets_consolidated.hashtag_id = game.fc1 or tweets_consolidated.hashtag_id = game.fc2) and (tweets_consolidated.created between game.officialstart and game.officialend)
group by game.officialstart, game.officialend, game.id;



select id, (num_tweets/(unix_timestamp(officialend)-unix_timestamp(officialstart)))*60 average from games_with_tweet_counts order by average desc limit 10;






























