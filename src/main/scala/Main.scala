import ui.worker.ConsoleWorker

object Main {

  val worker: ConsoleWorker = new ConsoleWorker

  def main(args: Array[String]): Unit = {

    worker.work(args.toSeq)
  }
}