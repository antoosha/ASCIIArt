package models.grids

import models.pixels.ASCIIPixel

case class ASCIIGrid(private val asciiGrid: Seq[Seq[ASCIIPixel]]) extends PixelGrid[ASCIIPixel] {

  override def getElement(x: Int, y: Int): ASCIIPixel = {

    if (x < 0 || x > getWidth || y < 0 || y > getHeight) {
      throw new IllegalStateException(s"Index is out of grid borders. Grid borders: ${this.getHeight}x${this.getWidth}")
    }
    asciiGrid(y)(x)
  }

  override def getWidth: Int = {
    if (getHeight == 0) {
      0
    }
    else {
      asciiGrid.head.length
    }
  }

  override def getHeight: Int = {
    asciiGrid.length
  }
}
