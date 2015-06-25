package generator.provider

import generator.temperature.Kelvin

/**
 *
 */
object AllOthersObservatoryProvider extends ObservatoryProvider with Kelvin {

  override val ObservatoryCode = "AO"

  override def balloonRow = super.balloonRow

  def measureTemperature = calculate
}
