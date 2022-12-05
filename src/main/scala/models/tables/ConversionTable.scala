package models.tables

trait ConversionTable[T, R] {

  def getConversionTable: T

  def getValue(idx: Int): R
}
