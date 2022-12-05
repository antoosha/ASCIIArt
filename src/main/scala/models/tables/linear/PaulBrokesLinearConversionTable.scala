package models.tables.linear

case class PaulBrokesLinearConversionTable() extends LinearConversionTable[String, Char] {

  private final val conversionTable: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override def offset: Int = 0

  override def getTableValues: String = conversionTable

  override def getValue(idx: Int): Char = {

    if (idx >= conversionTable.length) {
      throw new IllegalStateException("Index of the value in conversion table is out of bound.")
    }
    conversionTable(idx)
  }
}
