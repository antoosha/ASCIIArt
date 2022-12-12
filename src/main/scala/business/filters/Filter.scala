package business.filters

/**
 * Interface for filtering
 *
 * @tparam R item to filter
 */
trait Filter[R] {

  /**
   * Applies filter for an item
   *
   * @param image for apply filter
   * @return image after applying filter
   */
  def apply(image: R): R
}
