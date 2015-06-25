package generator.provider

import generator.temperature.Celsius

/**
 *
 */
object AustraliaObservatoryProvider extends ObservatoryProvider with Celsius {
  self =>

  override val ObservatoryCode = "AU"

  override def balloonRow = super.balloonRow

  def measureTemperature = calculate
}