package ui.worker

trait Worker[T] {

  def work(args: Seq[String]): Seq[T]
}
