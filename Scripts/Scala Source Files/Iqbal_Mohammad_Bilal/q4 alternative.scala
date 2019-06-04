var game1="/user/training/bigdata/game/"
var fc1="/user/training/bigdata/fc/"
var tweet1="/user/training/bigdata/tweet/"
var tweet_hashtag1="/user/training/bigdata/tweet_hashtag/"


var game2 = sc.textFile(game1)
var fc2 = sc.textFile(fc1)
var tweet2 = sc.textFile(tweet1)
var tweet_hashtag2 = sc.textFile(tweet_hashtag1)




var game3= game2.map (x => x.split(","))
var fc3= fc2.map (x => x.split(","))
var tweet3= tweet2.map (x => x.split(","))
var tweet_hashtag3= tweet_hashtag2.map (x => x.split(","))

var tweet4= tweet3.map(x=> (x(0), (x(1), x(2))))

val tweet_during_game= tweet_hashtag3.filter(x=> {x(1).toInt>0 && x(1).toInt<23})

var tweet_during_game2= tweet_during_game.map(x=> (x(0), ((x(1))))) 
val test= tweet_during_game2.join(tweet4)

var test2= test.map{case (k, (u)) => (k, u._1, u._2) }
var test3= test2.map{case (k, u, v) => (k, u, v._1, v._2) }

var game4= game3.map (x=> (x(0), x(1), x(2), x(3), x(4)))

var test4= test3.map(x=>(x._2, (x._1, x._3, x._4)))
var game5= game4.map(x=> (x._2, (x._1, x._4, x._5)))
var bigjoin= game5.join(test4)
var game6= game4.map(x=> (x._3, (x._1, x._4, x._5)))
var bigjoin2=game6.join(test4)

var bla=bigjoin.map {case (z, (x)) => (z, x._1, x._2)}
var bla2=bla.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}
var blu=bigjoin2.map {case (z, (x)) => (z, x._1, x._2)}
var blu2=blu.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}


import java.util.Date
import java.text.SimpleDateFormat
val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")
var bigjoinunix = bla2.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7))

var bigjoinunix2 = blu2.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7))

val during_game= bigjoinunix.filter(x=> {x._6>=x._3 && x._6<=x._4 }) 
val during_game2= bigjoinunix2.filter(x=> {x._6 >= x._3 && x._6<=x._4}) 

//structure is: hashtag, gameID, GameStart, GameEnd, TweetID, Created, UserID
//so we need to map: 1, 2, 4, 6
//before that though, let’s just start filtering
//and then map game ID with 1 to form a key value pair like Q1 to get tweet counts for each game
//at that particular time
//and then just add the values up like Q1, then join to get total number of tweets for each game at that time, //then easy peasy? maybe

val t0_1= during_game.filter(x=>(x._6==x._4)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))
val t0_2= during_game2.filter(x=>(x._6==x._4)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t1_1= during_game.filter(x=>(x._6==x._4-60)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t1_2= during_game2.filter(x=>(x._6==x._4-60)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t2_1= during_game.filter(x=>(x._6==x._4-120)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t2_2= during_game2.filter(x=>(x._6==x._4-120)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t3_1= during_game.filter(x=>(x._6==x._4-180)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t3_2= during_game2.filter(x=>(x._6==x._4-180)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t4_1= during_game.filter(x=>(x._6==x._4-240)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t4_2= during_game2.filter(x=>(x._6==x._4-240)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t5_1= during_game.filter(x=>(x._6==x._4-300)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t5_2= during_game2.filter(x=>(x._6==x._4-300)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t6_1= during_game.filter(x=>(x._6==x._4-360)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t6_2= during_game2.filter(x=>(x._6==x._4-360)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t7_1= during_game.filter(x=>(x._6==x._4-420)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t7_2= during_game2.filter(x=>(x._6==x._4-420)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t8_1= during_game.filter(x=>(x._6==x._4-480)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t8_2= during_game2.filter(x=>(x._6==x._4-480)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t9_1= during_game.filter(x=>(x._6==x._4-540)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t9_2= during_game2.filter(x=>(x._6==x._4-540)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t10_1= during_game.filter(x=>(x._6==x._4-600)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t10_2= during_game2.filter(x=>(x._6==x._4-600)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))


val t11_1= during_game.filter(x=>(x._6==x._4-660)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

val t11_2= during_game2.filter(x=>(x._6==x._4-660)).map (x=>(x._2, 1)).reduceByKey((accum, n) => (accum + n))

//Now join the two and add the values to get the total count at each minute

val    data=sc.parallelize(Seq(("1",0),("2",0),("3",0), ("4",0),("5",0), ("6",0) , ("7",0) , ("8",0) , ("9",0) , ("10",0) , ("11",0) , ("12",0) , ("13",0) , ("14",0) , ("15",0) , ("16",0) , ("17",0), ("18",0), ("19",0) , ("20",0), ("21",0) , ("22",0) , ("23",0) , ("24",0) , ("25",0) , ("26",0) , ("27",0) , ("28",0) , ("29",0) , ("30",0) , ("31",0) , ("32",0) , ("33",0) , ("34",0) , ("35",0) , ("36",0) , ("37",0) , ("38",0) , ("39",0) , ("40",0) , ("41",0) , ("42",0) , ("43",0) , ("44",0) , ("45",0) , ("46",0) , ("47",0) , ("48",0)))

val count0= t0_1.union(t0_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count1= t1_1.union(t1_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count2= t2_1.union(t2_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count3= t3_1.union(t3_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count4= t4_1.union(t4_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count5= t5_1.union(t5_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count6= t6_1.union(t6_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count7= t7_1.union(t7_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count8= t8_1.union(t8_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count9= t9_1.union(t9_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count10= t10_1.union(t10_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val count11= t11_1.union(t11_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))

//join all to get 1 rdd with counts at all 10 minutes
val hjk=count0.join(count1).join(count2).join(count3).join(count4).join(count5).join(count6).join(count7).join(count8).join(count9).join(count10).join(count11)
//map it to expand the nested structure
val gg=hjk.map{ case (id, (((((((((((t0, t1), t2), t3), t4), t5), t6), t7), t8), t9), t10), t11))=> (id, t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t10) }

val spike= gg.map (x=>(x._1, ((x._2+x._3)/2, (x._3+x._4)/2, (x._4+x._5)/2, (x._5+x._6)/2, (x._6+x._7)/2, (x._7+x._8)/2, (x._8+x._9)/2, (x._9+x._10)/2, (x._10+x._11)/2, (x._11+x._12)/2).max()))



