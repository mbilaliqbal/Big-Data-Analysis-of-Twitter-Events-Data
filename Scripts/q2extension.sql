invalidate metadata;

create view if not exists distinct_users
as
select  game.id GameNumber, count(distinct user_id) UserCount from tweets_consolidated, game

where 

(tweets_consolidated.created between game.officialstart and game.officialend) 

and 

(tweets_consolidated.hashtag_id = game.fc1 or tweets_consolidated.hashtag_id = game.fc2) 

group by game.id order by UserCount desc;





select distinct_users.GameNumber, num_tweets/usercount perUser 
from games_with_tweet_counts, distinct_users
where
distinct_users.GameNumber=games_with_tweet_counts.id
group by distinct_users.GameNumber, perUser order by perUser desc limit 10;
