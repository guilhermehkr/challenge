package generator.implicitly

import java.io.PrintWriter

/**
 *
 */
object ImplicitCases {
  implicit class PrinterWithFlushConditional(p: PrintWriter) {
    def flushIfNecessary(n: Int) : PrintWriter =
      if(n % 12500000 == 0) {
        println( s"flushing ... with memory: ${Runtime.getRuntime.freeMemory()} ")
        p.flush()
        Runtime.getRuntime.gc()
        p
      } else p
  }
}
