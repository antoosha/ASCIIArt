package models.grids

import models.pixels.RGBPixel

case class RGBGrid(private val rgbGrid: Seq[Seq[RGBPixel]]) extends PixelGrid[RGBPixel] {
  override def getElement(x: Int, y: Int): RGBPixel = {
    rgbGrid(y)(x)
  }

  override def getHeight: Int = {
    rgbGrid.length
  }

  override def getWidth: Int = {
    if (getHeight == 0) {
      0
    }
    else {
      rgbGrid.head.length
    }
  }
}
