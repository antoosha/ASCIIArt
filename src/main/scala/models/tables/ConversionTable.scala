package models.tables

trait ConversionTable[R] {

  def getConversionTable: R

  def getValue(idx: Int): R
}
