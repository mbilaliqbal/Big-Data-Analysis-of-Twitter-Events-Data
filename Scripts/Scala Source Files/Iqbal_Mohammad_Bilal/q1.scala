import org.apache.spark._
import org.apache.spark.SparkContext._

object Q1 {
    def main(args: Array[String]) {
      //val inputFile = args(0)
      //val outputFile = args(0)
      val conf = new SparkConf().setAppName("wordCount")
      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)
import java.util.Date
import java.text.SimpleDateFormat
val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")

var game3 = sc.textFile("/user/training/bigdata/game/").map (x => x.split(","))
var fc3 = sc.textFile("/user/training/bigdata/fc/").map (x => x.split(","))
var tweet3 = sc.textFile("/user/training/bigdata/tweet/").map (x => x.split(","))
var tweet_hashtag3 = sc.textFile("/user/training/bigdata/tweet_hashtag/").map (x => x.split(","))

var tweet4= tweet3.map(x=> (x(0), (x(1), x(2))))

val tweet_during_game= tweet_hashtag3.filter(x=> {x(1).toInt>0 && x(1).toInt<23})

var tweet_during_game2= tweet_during_game.map(x=> (x(0), ((x(1))))) 
val test= tweet_during_game2.join(tweet4)

val tweets_consolidated= test.map{case (k, (u)) => (k, u._1, u._2) }.map{case (k, u, v) => (k, u, v._1, v._2) }.map(x=>(x._2, (x._1, x._3, x._4)))

var game4= game3.map (x=> (x(0), x(1), x(2), x(3), x(4))).map(x=> (x._2, (x._1, x._4, x._5)))
var game5= game3.map (x=> (x(0), x(1), x(2), x(3), x(4))).map(x=> (x._3, (x._1, x._4, x._5)))

var bigjoin= game4.join(tweets_consolidated).map {case (z, (x)) => (z, x._1, x._2)}.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}
var bigjoin2=game5.join(tweets_consolidated).map {case (z, (x)) => (z, x._1, x._2)}.map{case (z, (x), (y))=> (z, x._1, x._2, x._3, y._1, y._2, y._3)}

val during_game= bigjoin.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7)).filter(x=> {x._6>x._3 && x._6<x._4 })

val during_game2= bigjoin2.map(x=> (x._1, x._2, formatter.parse(x._3.toString()).getTime()/1000, formatter.parse(x._4.toString()).getTime()/1000, x._5, formatter.parse(x._6.toString()).getTime()/1000, x._7)).filter(x=> {x._6>x._3 && x._6<x._4 })


val precount= during_game.map (x=> (x._2, 1)).reduceByKey((accum, n) => (accum + n))
val precount2= during_game2.map (x=> (x._2, 1)).reduceByKey((accum, n) => (accum + n))

val countjoin=  precount.join(precount2)
val totalcount= countjoin.map(x=> (x._1, (x._2._1+x._2._2)))

val gametime= game3.map(x=>(x(0), x(3), x(4)))

var gametimeunix= gametime.map(x=> (x._1, formatter.parse(x._2.toString()).getTime()/1000, formatter.parse(x._3.toString()).getTime()/1000))

val gameduration= gametimeunix.map(x=> (x._1, x._3-x._2))
val prefinal= totalcount.join(gameduration)
val almostfinal= prefinal.map(x=> (x._1, x._2._1.toDouble/x._2._2.toDouble))
val afinal= almostfinal.map(x=> (x._1, x._2*60))
val asd= afinal.sortBy(_._2, false).zipWithIndex.filter(_._2<10)
asd.saveAsTextFile("/user/training/q1.txt")
afinal.sortBy(_._2, false).take(10)
     
    }
}

