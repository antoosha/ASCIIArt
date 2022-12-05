package models.tables.linear

case class UserLinearConversionTable(private var conversionTable: String = "") extends LinearConversionTable[String] {

  override def getConversionTable: String = conversionTable

  def setConversionTable(conversionTable: String): Unit = {
    this.conversionTable = conversionTable
  }

  override def getValue(idx: Int): String = {

    if (idx >= conversionTable.length) {
      throw new IllegalStateException("Index of the value in conversion table is out of bound.")
    }
    conversionTable(idx).toString
  }

}
