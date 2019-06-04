--game 36

select 
cast(unix_timestamp(created)/60 as bigint)
, count(tweet_id) 
from tweets_consolidated 
where 
cast(unix_timestamp(tweets_consolidated.created)/60 as bigint)
> 
cast(unix_timestamp('2017-12-02 17:30:00.0')/60 as bigint)
and 
cast(unix_timestamp(created)/60 as bigint) 
< 
cast (unix_timestamp('2017-12-02 19:23:00.0')/60 as bigint)
and (hashtag_id=14 or hashtag_id=3) 
group by 
cast(unix_timestamp(created)/60 as bigint)
order by 
cast(unix_timestamp(created)/60 as bigint);