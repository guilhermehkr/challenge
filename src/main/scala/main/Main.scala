package main

import akka.actor.ActorSystem
import generator.actor.FileWriterActor
import generator.actor.FileWriterActor.Message
import generator.provider.SummaryProvider

/**
 * Main process
 */
object Main extends App {

  val PathFile = "target/data"

  val actorSystem = ActorSystem("root")
  val fileWriterActor = actorSystem.actorOf(FileWriterActor.props, "FileWriterActor")

  val rangeOption = args.map {
    total =>
      val rowsPerObservatory = total.toInt / 4
      1 to rowsPerObservatory
  }.headOption

  import akka.pattern.ask
  import scala.concurrent.duration._
  import akka.util.Timeout
  import scala.concurrent.ExecutionContext.Implicits.global

  implicit val timeout = Timeout( 1 hour )
  rangeOption.foreach {
    range =>
      ask(fileWriterActor, Message(range, PathFile)).onComplete {
        result =>
          SummaryProvider.summary(PathFile)
      }
  }

  actorSystem.shutdown()
}
