package business.generators

/**
 * Interface for generating
 *
 * @tparam R generated item
 */
trait Generator[R] {

  /**
   * Generates item
   *
   * @return generated item
   */
  def generate(): R
}
