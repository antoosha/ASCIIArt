package ui.worker

trait Worker {

  def work(args: Seq[String]): Unit
}
