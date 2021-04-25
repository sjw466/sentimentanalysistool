import org.apache.spark.sql.SparkSession
import scala.io.Source

object DataAnalytics{
        def main(args : Array[String]) : Unit ={
                val df = spark.read.csv(args(0))
                val pos = Source.fromFile("positive-words.txt").getLines.toArray
                val neg = Source.fromFile("negative-words.txt").getLines.toArray
                val df2= df.withColumnRenamed("_c0", "Topic") .withColumnRenamed("_c1", "Article Text")
                println("Please type keyword: ")
                var input = scala.io.StdIn.readLine()
                input = input.toLowerCase()
                val blair = df2.filter($"Article Text".contains(input))
                val blairtext= blair.select("Article Text").collect().mkString(" ")
                var sentiment = 0
                for(i <- 1 to pos.length-1){
                        if(blairtext.contains(pos(i))){
                                sentiment+=1
                        }
                }
                for(i <- 1 to neg.length-1){
                        if(blairtext.contains(neg(i))){
                                sentiment-=1
                        }
                }
                if(sentiment<100){
                        println("Sentiment score for "+ input + " is:" + sentiment +", thus overall sentiment is bad")
                }else if(sentiment>100){
                        println("Sentiment score for "+ input + " is:" + sentiment +", thus overall sentiment is good")
                }else{
                        println("Sentiment score for "+ input + " is:" + sentiment +", thus overall sentiment is neutral")
                }


        }
}