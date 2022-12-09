import ui.worker.{ConsoleWorker, Worker}

object Main {

  val worker: Worker = new ConsoleWorker

  def main(args: Array[String]): Unit = {

    worker.work(args.toSeq)
  }
}