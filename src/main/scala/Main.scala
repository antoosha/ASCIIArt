import ui.worker.{ConsoleWorker, Worker}

object Main {

  val worker: Worker = new ConsoleWorker

  def main(args: Array[String]): Unit = {

    println("W E L C O M E   T O   A S C I I A R T   A P P L I C A T I O N ! ! !")
    worker.work(args.toList)
  }
}