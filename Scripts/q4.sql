--Create view for last 10 minutes
create view if not exists ten
as
select game.id, game.fc1, game.fc2, cast(unix_timestamp(game.officialend)-600 as timestamp) as t10, game.officialend from game; 

--Calculate the average for the last 10 minutes 
create view if not exists ten_with_tweet_counts
as
select ten.id, (count(distinct tweets_consolidated.tweet_id))/10 num_tweets from ten join tweets_consolidated  
where
(tweets_consolidated.hashtag_id = ten.fc1 or tweets_consolidated.hashtag_id = ten.fc2) and (tweets_consolidated.created between ten.t10 and ten.officialend)
group by ten.id, ten.t10, ten.officialend;

--Creating iew for interval before the last 10 minutes
create view if not exists until_ten
as
select game.id, game.fc1, game.fc2, cast(unix_timestamp(game.officialend)-600 as timestamp) as t10, game.officialstart from game;

--Counting the average of tweets for interval before the last 10 minutes
create view if not exists until_ten_with_tweet_counts
as
select until_ten.id, ((count(distinct tweets_consolidated.tweet_id))/(unix_timestamp(t10)-unix_timestamp(officialstart)))*60 num_tweets from until_ten join tweets_consolidated  
where
(tweets_consolidated.hashtag_id = until_ten.fc1 or tweets_consolidated.hashtag_id = until_ten.fc2) and (tweets_consolidated.created between until_ten.officialstart and until_ten.t10)
group by until_ten.id, until_ten.t10, until_ten.officialstart;

--Bring the two total views together
create view if not exists prespike_q4
as
select until_ten_with_tweet_counts.id, ten_with_tweet_counts.num_tweets ten, until_ten_with_tweet_counts.num_tweets untilten from until_ten_with_tweet_counts join ten_with_tweet_counts
where until_ten_with_tweet_counts.id=ten_with_tweet_counts.id;

--Divide to get the ratio
select id, ten/untilten spike from prespike_q4 group by id, spike order by spike desc limit 10;
