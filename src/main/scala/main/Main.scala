package main

import akka.actor.ActorSystem
import generator.actor.FileWriterActor
import generator.actor.FileWriterActor.Message

/**
 * Main process
 */
object Main extends App {

  val actorSystem = ActorSystem("root")
  val fileWriterActor = actorSystem.actorOf(FileWriterActor.props, "FileWriterActor")

  val rangeOption = args.map {
    total =>
      val rowsPerObservatory = total.toInt / 4
      1 to rowsPerObservatory
  }.headOption

  rangeOption.foreach( fileWriterActor ! Message( _ ) )

  actorSystem.shutdown()
}
