package models.images

import models.grids.pixel.RGBGrid
import models.pixels.RGBPixel

case class RGBImage(private val rgbGrid: RGBGrid) extends Image {
  override def getPixel(x: Int, y: Int): RGBPixel = {
    rgbGrid.getElement(x, y)
  }

  override def getHeight: Int = {
    rgbGrid.getHeight
  }

  override def getWidth: Int = {
    rgbGrid.getWidth
  }
}
