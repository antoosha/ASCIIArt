package ui.worker

/**
 * Interface for working
 *
 * @tparam T
 */
trait Worker[T] {

  /**
   * Resolves input commands
   *
   * @param args to resolve
   * @return resolved commands
   */
  def work(args: Seq[String]): Seq[T]
}
