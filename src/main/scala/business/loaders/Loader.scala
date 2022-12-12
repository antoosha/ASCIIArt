package business.loaders

/**
 * Interface for loading
 *
 * @tparam R loaded item
 */
trait Loader[R] {

  /**
   * Loads item
   *
   * @return loaded item
   */
  def load(): R
}
