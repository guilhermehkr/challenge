package generator.provider

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scala.util.Random

/**
 *
 */
trait ObservatoryProvider {
  
  val Pattern = "<timestamp>|<location>|<temperature>|<observatory>"

  val ObservatoryCode = "UnKnow"
  val CoOrdinateBase = 400000

  def balloonRow = {

    val timeStamp = LocalDateTime.now.format( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm") )
    val latitude = Random.nextInt(CoOrdinateBase)
    val longitude = Random.nextInt(CoOrdinateBase)

    if(Random.nextInt > 0)
      s"$timeStamp|$latitude,$longitude|$measureTemperature|$ObservatoryCode"
    else
      Pattern
  }

  def measureTemperature: Int
}
