package models.tables.linear

class UserLinearConversionTable extends LinearConversionTable[String, Char] {

  private var conversionTable: String = ""

  override def getTableValues: String = conversionTable

  override def offset: Int = 0

  def this(conversionTable: String) {
    this()
    if (conversionTable.isEmpty) {
      throw new IllegalArgumentException("Conversion table should not be empty.")
    }
    this.conversionTable = conversionTable
  }

  override def getValue(idx: Int): Char = {

    if (idx >= conversionTable.length) {
      throw new IllegalStateException("Index of the value in conversion table is out of bound.")
    }
    conversionTable(idx)
  }

}
