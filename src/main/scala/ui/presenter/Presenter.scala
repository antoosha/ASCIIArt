package ui.presenter

/**
 * Present something.
 *
 * @tparam T output stream where to present result.
 * @tparam R result to present.
 */
trait Presenter[T, R] {

  def present(os: T, res: R): Unit
}
