package models.images

import models.grids.ASCIIGrid
import models.pixels.ASCIIPixel

case class ASCIIImage(private val asciiGrid: ASCIIGrid) extends Image {
  override def getPixel(x: Int, y: Int): ASCIIPixel = {
    asciiGrid.getElement(x, y)
  }

  override def getHeight: Int = {
    asciiGrid.getHeight
  }

  override def getWidth: Int = {
    asciiGrid.getWidth
  }
}
