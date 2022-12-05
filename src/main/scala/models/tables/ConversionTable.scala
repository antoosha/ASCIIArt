package models.tables

trait ConversionTable[T, R] {

  def getTableValues: T

  def getValue(idx: Int): R

  def offset: Int
}
