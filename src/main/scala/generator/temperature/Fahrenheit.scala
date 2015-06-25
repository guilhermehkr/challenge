package generator.temperature

import scala.util.Random

/**
 * Created by guilhermehkr on 25/06/15.
 */
trait Fahrenheit {

  def calculate = Random.nextInt(180)
}
