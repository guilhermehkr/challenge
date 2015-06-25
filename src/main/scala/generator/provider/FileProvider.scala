package generator.provider

import java.io.{PrintWriter, FileWriter}
import generator.implicitly.ImplicitCases._

/**
 * Service that will write in file
 */
object FileProvider {

  def write(row: String)(implicit rowsPerObservatory: Int): Unit = {

    val file = new PrintWriter(new FileWriter("target/newww", true))
    for (n <- 1 to rowsPerObservatory)
      file.flushIfNecessary(n).println(row)

    file.close()
  }
}
