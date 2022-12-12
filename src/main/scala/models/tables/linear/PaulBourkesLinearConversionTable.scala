package models.tables.linear

/**
 * Concrete data model of PaulBourkesLinearConversionTable
 */
case class PaulBourkesLinearConversionTable() extends LinearConversionTable[String, Char] {

  private final val conversionTable: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override def offset: Int = 0

  /**
   * Gets all table values
   *
   * @return all table values
   */
  override def getTableValues: String = conversionTable

  /**
   * Gets concrete value by idx from table
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
