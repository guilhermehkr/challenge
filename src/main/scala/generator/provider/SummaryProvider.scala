package generator.provider

import java.nio.file.{Files, Paths}

/**
 *
 */
object SummaryProvider {

  def summary(filePath: String) = {

    import scala.collection.JavaConversions.asScalaBuffer
    val buffer = asScalaBuffer( Files.readAllLines( Paths.get(filePath) ) )

    val map = buffer.groupBy {
      row => row.split('|')(3)
    }

    println( s"The number of observations from each observatory are: " )
    map.foreach {
      case(key, value) =>
          println( s"$key - $value" )
    }
  }
}
