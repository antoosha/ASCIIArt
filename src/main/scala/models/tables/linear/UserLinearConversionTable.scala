package models.tables.linear

case class UserLinearConversionTable(private var conversionTable: String = "") extends LinearConversionTable[String, Char] {

  override def getTableValues: String = conversionTable

  override def offset: Int = 0

  def setConversionTable(conversionTable: String): Unit = {
    this.conversionTable = conversionTable
  }

  override def getValue(idx: Int): Char = {

    if (idx >= conversionTable.length) {
      throw new IllegalStateException("Index of the value in conversion table is out of bound.")
    }
    conversionTable(idx)
  }

}
