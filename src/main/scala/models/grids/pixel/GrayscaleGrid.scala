package models.grids.pixel

import models.grids.PixelGrid
import models.pixels.GrayscalePixel

case class GrayscaleGrid(private val grayscaleGrid: Seq[Seq[GrayscalePixel]]) extends PixelGrid[GrayscalePixel] {

  override def getElement(x: Int, y: Int): GrayscalePixel = {

    if (x < 0 || x > getWidth || y < 0 || y > getHeight) {
      throw new IllegalStateException(s"Index is out of grid borders. Grid borders: ${this.getHeight}x${this.getWidth}")
    }
    grayscaleGrid(y)(x)
  }

  override def getWidth: Int = {
    if (getHeight == 0) {
      0
    }
    else {
      grayscaleGrid.head.length
    }
  }

  override def getHeight: Int = {
    grayscaleGrid.length
  }
}
