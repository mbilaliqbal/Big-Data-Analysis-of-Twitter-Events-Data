import org.apache.spark._
import org.apache.spark.SparkContext._

object Q6 {
    def main(args: Array[String]) {
      //val inputFile = args(0)
      //val outputFile = args(0)
      val conf = new SparkConf().setAppName("wordCount")
      // Create a Scala Spark Context.
      val sc = new SparkContext(conf)
import java.util.Date
import java.text.SimpleDateFormat
val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")

var tweet3 = sc.textFile("/user/training/bigdata/tweet/").map (x => x.split(","))

var tweet_hashtag3 = sc.textFile("/user/training/bigdata/tweet_hashtag/").map (x => x.split(","))

var tweet4= tweet3.map(x=> (x(0), (x(1), x(2))))

val tweet_during_game2= tweet_hashtag3.filter(x=> {x(1).toInt>0 && x(1).toInt<23}).map(x=> (x(0), ((x(1))))) 

val tweet_consolidated= tweet_during_game2.join(tweet4).map{case (k, (u)) => (k, u._1, u._2) }.map{case (k, u, v) => (k, u, v._1, v._2) }

val tweet_consolidated2= tweet_consolidated.map(x=>(x._1, x._2, formatter.parse(x._3).getTime()/1000.toLong, x._4))

val starttime= "2017-12-02 17:30:00.0"
val endtime= "2017-12-02 19:23:00.0"

val tweet_consolidated3= tweet_consolidated2.filter(x=>x._3>=formatter.parse(starttime).getTime().toLong/1000 && x._3<=formatter.parse(endtime).getTime().toLong/1000).filter(x=> x._2=="3" || x._2=="14")

val forgraph= tweet_consolidated3.map(x=> (x._3/60.toInt, 1)).reduceByKey((accum, n) => (accum + n))
val asd= forgraph.sortBy(_._1)
asd.saveAsTextFile("/user/training/q6.txt")
     
    }
}

