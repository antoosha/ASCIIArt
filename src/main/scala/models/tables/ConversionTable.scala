package models.tables

/**
 * Abstract data model of ConversionTable
 *
 * @tparam T table values
 * @tparam R one table value
 */
trait ConversionTable[T, R] {

  /**
   * Gets all values
   *
   * @return all table values
   */
  def getTableValues: T

  /**
   * Get concrete value by idx
   *
   * @param idx of the value in table
   * @return concrete value
   */
  def getValue(idx: Int): R

  /**
   * Offset of the conversion table
   *
   * @return
   */
  def offset: Int
}
