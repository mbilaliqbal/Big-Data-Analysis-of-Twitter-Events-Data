import org.apache.spark._
import org.apache.spark.SparkContext._

object Q5 {
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
var hashtag4= sc.textFile("/user/training/bigdata/hashtag/").filter(x=>x.length>4).map (x => x.split(",")).map(x=>(x(0), (x(1))))


//calculating the tweets consolidated RDD 
//we only care about non-official hashtags --we will filter this ONLY after getting bigjoins
var tweet4= tweet3.map(x=> (x(0), (x(1), x(2))))
val tweet_during_game= tweet_hashtag3.map(x=> (x(0), ((x(1)))))

val tweet_consolidated= tweet_during_game.join(tweet4).map{case (k, (u)) => (k, u._1, u._2) }.map{case (k, u, v) => (k, u, v._1, v._2) }.map(x=>(x._2, (x._1, x._3, x._4)))

var game4= game3.map (x=> (x(0), x(1), x(2), x(3), x(4)))

var game5= game4.map(x=> (x._2, (x._1, x._4, x._5)))
var bigjoin= game5.join(tweet_consolidated).map {case (z, (x)) => (z, x._1, x._2)}.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}

var game6= game4.map(x=> (x._3, (x._1, x._4, x._5)))
var bigjoin2=game6.join(tweet_consolidated).map {case (z, (x)) => (z, x._1, x._2)}.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}

val bigjoinunix = bigjoin.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7))
var bigjoinunix2 = bigjoin2.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7))

val during_game= bigjoinunix.filter(x=> {x._6>x._3 && x._6<x._4 }) 
val during_game2= bigjoinunix2.filter(x=> {x._6 > x._3 && x._6<x._4}) 

val nonoff_dg= during_game.map(x=>(x._5, (x._1)))
val nonoff_dg2= during_game2.map(x=>(x._5, (x._1)))

val tweets_consolidated2= tweet_during_game.join(tweet4)

val nonoff= nonoff_dg.join(tweets_consolidated2).map(x=>(x._1, x._2._2._1)).filter(x=>{x._2.toInt>22})
val nonoff2= nonoff_dg2.join(tweets_consolidated2).map(x=>(x._1, x._2._2._1)).filter(x=>{x._2.toInt>22})

val abc= nonoff.map(x=>(x._2, (1))).reduceByKey((accum, n) => (accum + n))
val abc2= nonoff2.map(x=>(x._2, (1))).reduceByKey((accum, n) => (accum + n))

val prefinal=abc.join(abc2).map(x=> (x._1,x._2._1+x._2._1))

val prefinal2= prefinal.map(x=> (x._1, (x._2)))
val afinal= prefinal2.join(hashtag4).map(x=> (x._1, x._2._1, x._2._2))

val asd= afinal.sortBy(_._2, false).zipWithIndex.filter(_._2<10)
asd.saveAsTextFile("/user/training/q5.txt")

afinal.sortBy(_._2, false).take(10)

     
    }
}

