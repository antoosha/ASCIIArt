package models.grids

trait Grid[T] {

  def getElement(x: Int, y: Int): T

  def getHeight: Int

  def getWidth: Int

}
