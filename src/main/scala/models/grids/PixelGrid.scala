package models.grids

import models.pixels.Pixel

trait PixelGrid[T <: Pixel] extends Grid[Pixel] {

  override def getElement(x: Int, y: Int): Pixel

  override def getHeight: Int

  override def getWidth: Int
}
