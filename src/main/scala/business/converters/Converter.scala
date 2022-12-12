package business.converters

/**
 * Interface for T to R conversion
 *
 * @tparam T item to convert
 * @tparam R converted item
 */
trait Converter[T, R] {

  /**
   *
   * Converts an item
   *
   * @param item to convert
   * @return converted item
   */
  def convert(item: T): R
}
