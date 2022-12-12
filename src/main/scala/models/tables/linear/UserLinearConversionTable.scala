package models.tables.linear

/**
 * Concrete data model of UserLinearConversionTable
 */
class UserLinearConversionTable extends LinearConversionTable[String, Char] {

  private var conversionTable: String = ""

  override def offset: Int = 0

  /**
   * ets all table values
   *
   * @return all table values
   */
  override def getTableValues: String = conversionTable

  /**
   * Constructor of with checked required parameter
   *
   * @param conversionTable is table values of conversion table
   */
  def this(conversionTable: String) {

    this()
    if (conversionTable.isEmpty) {
      throw new IllegalArgumentException("Conversion table should not be empty.")
    }
    this.conversionTable = conversionTable
  }

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
