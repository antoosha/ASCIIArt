package models.grids

import models.pixels.Pixel

trait PixelGrid[T <: Pixel] extends Grid[Pixel] {

  override def getElement(x: Int, y: Int): Pixel

  def getHeight: Int

  def getWidth: Int
}
