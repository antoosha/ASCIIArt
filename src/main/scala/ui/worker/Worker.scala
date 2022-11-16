package ui.worker

trait Worker {
  def work(args: List[String]): Unit
}
