package generator.provider

import generator.temperature.Kelvin

/**
 *
 */
object FranceObservatoryProvider extends ObservatoryProvider with Kelvin {

  override val ObservatoryCode = "FR"

  override def balloonRow = super.balloonRow

  def measureTemperature = calculate
}
