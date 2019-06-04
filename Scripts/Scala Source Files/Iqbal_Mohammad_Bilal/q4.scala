import org.apache.spark._
import org.apache.spark.SparkContext._

object Q4 {
    def main(args: Array[String]) {
      //val inputFile = args(0)
      //val outputFile = args(0)
      val conf = new SparkConf().setAppName("wordCount")
      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)
//importing libraries
import java.util.Date
import java.text.SimpleDateFormat
val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")

//reading files into RDDs
var game3 = sc.textFile("/user/training/bigdata/game/").map (x => x.split(","))
var fc3 = sc.textFile("/user/training/bigdata/fc/").map (x => x.split(","))
var tweet3 = sc.textFile("/user/training/bigdata/tweet/").map (x => x.split(","))
var tweet_hashtag3 = sc.textFile("/user/training/bigdata/tweet_hashtag/").map (x => x.split(","))

//calculating the tweets consolidated RDD
var tweet4= tweet3.map(x=> (x(0), (x(1), x(2))))
val tweet_during_game= tweet_hashtag3.filter(x=> {x(1).toInt>0 && x(1).toInt<23})
var tweet_during_game2= tweet_during_game.map(x=> (x(0), ((x(1))))) 
val test= tweet_during_game2.join(tweet4)
val tweets_consolidated= test.map{case (k, (u)) => (k, u._1, u._2) }.map{case (k, u, v) => (k, u, v._1, v._2) }.map(x=>(x._2, (x._1, x._3, x._4)))

//filtering out the tweets that were created during the game 
var game4= game3.map (x=> (x(0), x(1), x(2), x(3), x(4))).map(x=> (x._2, (x._1, x._4, x._5)))
var game5= game3.map (x=> (x(0), x(1), x(2), x(3), x(4))).map(x=> (x._3, (x._1, x._4, x._5)))

var bigjoin= game4.join(tweets_consolidated).map {case (z, (x)) => (z, x._1, x._2)}.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}
var bigjoin2=game5.join(tweets_consolidated).map {case (z, (x)) => (z, x._1, x._2)}.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}


var during_gam = bigjoin.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7)).filter(x=> {x._6>=x._3 && x._6<=x._4 })
var during_gam2 = bigjoin2.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7)).filter(x=> {x._6>=x._3 && x._6<=x._4 })

val during_game= during_gam.map(x=> (x._5, (x._1, x._2, x._3, x._4, x._6, x._7))).groupByKey().map(x=>(x._1, x._2.toList)).flatMap{case(key, list) => list.map(x => (key, x._1, x._2, x._3, x._4, x._5, x._6))}
val during_game2= during_gam2.map(x=> (x._5, (x._1, x._2, x._3, x._4, x._6, x._7))).groupByKey().map(x=>(x._1, x._2.toList)).flatMap{case(key, list) => list.map(x => (key, x._1, x._2, x._3, x._4, x._5, x._6))}
//Array((939497334181912577,List((22,39,1512851400,1512858000,939497334181912577,595702850))))
//TweetID (1), Hashtag (2), GameID (3), GameStart (4), GameEnd (5), Created (6), UserID (7)

//Count total number of tweets for each interval
val t10_1= during_game.filter(x=>(x._6>=x._5-600 && x._6<=x._5)).map (x=>(x._3, 1)).reduceByKey((accum, n) => (accum + n))
val t10_2= during_game2.filter(x=>(x._6>=x._5-600 && x._6<=x._5)).map (x=>(x._3, 1)).reduceByKey((accum, n) => (accum + n))
val until_t10_1= during_game.filter(x=>(x._6>=x._4 && x._6<x._5-600)).map (x=>(x._3, 1)).reduceByKey((accum, n) => (accum + n))
val until_t10_2= during_game2.filter(x=>(x._6>=x._4 && x._6<x._5-600)).map (x=>(x._3, 1)).reduceByKey((accum, n) => (accum + n))

val    data=sc.parallelize(Seq(("1",0),("2",0),("3",0), ("4",0),("5",0), ("6",0) , ("7",0) , ("8",0) , ("9",0) , ("10",0) , ("11",0) , ("12",0) , ("13",0) , ("14",0) , ("15",0) , ("16",0) , ("17",0), ("18",0), ("19",0) , ("20",0), ("21",0) , ("22",0) , ("23",0) , ("24",0) , ("25",0) , ("26",0) , ("27",0) , ("28",0) , ("29",0) , ("30",0) , ("31",0) , ("32",0) , ("33",0) , ("34",0) , ("35",0) , ("36",0) , ("37",0) , ("38",0) , ("39",0) , ("40",0) , ("41",0) , ("42",0) , ("43",0) , ("44",0) , ("45",0) , ("46",0) , ("47",0) , ("48",0)))

val count10= t10_1.union(t10_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))
val until_count10= until_t10_1.union(until_t10_2). map(x=> (x._1, (x._2))).reduceByKey((accum, n) => (accum + n)).union(data).reduceByKey((accum, n) => (accum + n))

//we need to find game duration to get average for first half
val gametime= game3.map(x=>(x(0), x(3), x(4)))

var gametimeunix= gametime.map(x=> (x._1, formatter.parse(x._2.toString()).getTime()/1000, formatter.parse(x._3.toString()).getTime()/1000))

//to remove the last ten minutes
val gameduration= gametimeunix.map(x=> (x._1, (x._3-x._2-600)/60))

val count10_2= count10.map (x=>(x._1, x._2.toDouble/10))
val until_count10_2=until_count10.join(gameduration).map(x=>(x._1, x._2._1.toDouble/x._2._2.toDouble))

//Save final answer
val prefinal= count10_2.join(until_count10_2)
val afinal=prefinal.map(x=>(x._1, x._2._1/(x._2._2)))
val asd= afinal.sortBy(_._2, false).zipWithIndex.filter(_._2<10)
asd.saveAsTextFile("/user/training/q4.txt")

     
    }
}

