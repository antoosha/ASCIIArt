import ui.worker.{ConsoleWorker, Worker}

object Main {

  val worker: Worker = new ConsoleWorker

  def main(args: Array[String]): Unit = {

    println("Welcome to ASCIIArt application!!!")
    worker.work(args.toList)
  }
}