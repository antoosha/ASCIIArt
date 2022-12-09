package models.tables.nonlinear

case class SimpleNonLinearConversionTable() extends NonLinearConversionTable[String, Char] {

  private val conversionTable: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  override def offset: Int = 100

  override def getTableValues: String = conversionTable

  override def getValue(idx: Int): Char = {

    if (idx < 0 || idx >= conversionTable.length) {
      throw new IllegalStateException("Index of the value in conversion table is out of bound.")
    }
    conversionTable(idx)
  }
}
