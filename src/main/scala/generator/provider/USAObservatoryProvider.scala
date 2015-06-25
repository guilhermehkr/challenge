package generator.provider

import generator.temperature.Fahrenheit

/**
 *
 */
object USAObservatoryProvider extends ObservatoryProvider with Fahrenheit {
  self =>

  override val ObservatoryCode = "US"

  override def balloonRow = super.balloonRow

  def measureTemperature = calculate
}
