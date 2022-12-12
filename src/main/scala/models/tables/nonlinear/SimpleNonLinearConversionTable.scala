package models.tables.nonlinear

/**
 * Concrete data model of SimpleNonLinearConversionTable
 */
case class SimpleNonLinearConversionTable() extends NonLinearConversionTable[String, Char] {

  private val conversionTable: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override def offset: Int = 100

  /**
   * Gets table values
   *
   * @return all table values
   */
  override def getTableValues: String = conversionTable

  /**
   * Gets concrete value by idx from the table values
   *
   * @param idx of the value in table
   * @return concrete value
   */
  override def getValue(idx: Int): Char = {

    if (idx < 0 || idx >= conversionTable.length) {
      throw new IllegalStateException("Index of the value in conversion table is out of bound.")
    }
    conversionTable(idx)
  }
}
