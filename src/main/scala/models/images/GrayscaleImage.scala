package models.images

import models.grids.pixel.GrayscaleGrid
import models.pixels.GrayscalePixel

case class GrayscaleImage(private val grayscaleGrid: GrayscaleGrid) extends Image {

  override def getPixel(x: Int, y: Int): GrayscalePixel = {
    grayscaleGrid.getElement(x, y)
  }

  override def getHeight: Int = {
    grayscaleGrid.getHeight
  }

  override def getWidth: Int = {
    grayscaleGrid.getWidth
  }
}
