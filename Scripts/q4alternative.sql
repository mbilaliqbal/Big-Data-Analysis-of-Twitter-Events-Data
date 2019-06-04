invalidate metadata;

create view if not exists ten_minutes_interval
as
select 
game.id,
cast(unix_timestamp(game.officialend)-660 as timestamp) as 'T11', 
cast(unix_timestamp(game.officialend)-600 as timestamp) as 'T10', 
cast(unix_timestamp(game.officialend)-540 as timestamp) as 'T9',
cast(unix_timestamp(game.officialend)-480 as timestamp) as 'T8',
cast(unix_timestamp(game.officialend)-420 as timestamp) as 'T7',
cast(unix_timestamp(game.officialend)-360 as timestamp) as 'T6',
cast(unix_timestamp(game.officialend)-300 as timestamp) as 'T5',
cast(unix_timestamp(game.officialend)-240 as timestamp) as 'T4',
cast(unix_timestamp(game.officialend)-180 as timestamp) as 'T3',
cast(unix_timestamp(game.officialend)-120 as timestamp) as 'T2',
cast(unix_timestamp(game.officialend)-60 as timestamp) as 'T1',
officialend as 'T'
from game;



create view if not exists t11
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t11
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t10
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t10
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t9
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t9
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t8
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t8
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t7
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t7
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t6
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t6
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t5
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t5
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t4
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t4
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t3
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t3
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t2
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t2
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t1
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t1
group by ten_minutes_interval.id order by ten_minutes_interval.id;

create view if not exists t0
as
select ten_minutes_interval.id, count(*) 
from  ten_minutes_interval full join tweets_consolidated
on tweets_consolidated.created= ten_minutes_interval.t
group by ten_minutes_interval.id order by ten_minutes_interval.id;



create view if not exists last_ten_minutes
as
select t11.id, t11.`_c1` as t11, t10.`_c1` as t10, t9.`_c1` as t9, t8.`_c1` as t8, 
t7.`_c1` as t7, t6.`_c1` as t6, t5.`_c1` as t5, t4.`_c1` as t4, t3.`_c1`as t3,
t2.`_c1` as t2, t1.`_c1` as t1, t0.`_c1`as t0

from 
t11 join t10 on t11.id=t10.id 
join t9 on t11.id=t9.id 
join t8 on t11.id=t8.id
join t7 on t11.id=t7.id
join t6 on t11.id=t6.id
join t5 on t11.id=t5.id
join t4 on t11.id=t4.id
join t3 on t11.id=t3.id
join t2 on t11.id=t2.id
join t1 on t11.id=t1.id
join t0 on t11.id=t0.id;


create view if not exists moving_average
as
select last_ten_minutes.id, (t11+t10)/2 mvave10, (t10+t9)/2 mvave9, (t9+t8)/2 mvave8, (t8+t7)/2 mvave7, (t7+t6)/2 mvave6, 
(t6+t5)/2 mvave5, (t5+t4)/2 mvave4, (t4+t3)/2 mvave3, (t2+t1)/2 mvave2, (t1+t0)/2 mvave1
from last_ten_minutes;


select moving_average.id, greatest(mvave9/mvave10, mvave8/mvave9, mvave7/mvave8, mvave6/mvave7,
mvave5/mvave6, mvave4/mvave5, mvave3/mvave4, mvave2/mvave3, mvave1/mvave2) as MaxSpike from moving_average order by MaxSpike desc limit 10;

