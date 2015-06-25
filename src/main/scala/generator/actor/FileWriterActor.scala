package generator.actor

import java.io.{FileWriter, PrintWriter}
import java.time.LocalDateTime

import akka.actor.{Props, ActorLogging, Actor}
import generator.actor.FileWriterActor.Message
import generator.provider.{AllOthersObservatoryProvider, FranceObservatoryProvider, USAObservatoryProvider, AustraliaObservatoryProvider}


/**
 *
 */
class FileWriterActor extends Actor with ActorLogging {

  def receive = {
    case Message(range, pathFile) =>

      val printer = new PrintWriter(new FileWriter(pathFile, true))

      log.info( s"Start time -> ${LocalDateTime.now} - memory -> ${Runtime.getRuntime.freeMemory()}")
      range.foreach {
        row =>

          val ausRow = AustraliaObservatoryProvider.balloonRow
          val usRow = USAObservatoryProvider.balloonRow
          val frRow = FranceObservatoryProvider.balloonRow
          val aoRow = AllOthersObservatoryProvider.balloonRow
          val lineSeparator = System.lineSeparator()
          val totalRow = s"$ausRow $lineSeparator $usRow $lineSeparator $frRow $lineSeparator $aoRow"

          import generator.implicitly.ImplicitCases._
          printer.flushIfNecessary( row ).println( totalRow )
      }

      log.info( s"Finish time -> ${LocalDateTime.now} - memory -> ${Runtime.getRuntime.freeMemory()}")
  }
}

object FileWriterActor {
  val props = Props[FileWriterActor]

  case class Message(range: Range, pathFile: String)
}

