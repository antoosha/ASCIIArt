package business.exporters

/**
 * Interface for exporting
 *
 * @tparam T data to export
 */
trait Exporter[T] {

  /**
   * Exports data
   *
   * @param item data to export
   */
  def export(item: T): Unit

}
