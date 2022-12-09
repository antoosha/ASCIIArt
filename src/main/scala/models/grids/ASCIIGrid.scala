package models.grids

import models.pixels.ASCIIPixel

case class ASCIIGrid(private val asciiGrid: Seq[Seq[ASCIIPixel]]) extends PixelGrid[ASCIIPixel] {

  override def getElement(x: Int, y: Int): ASCIIPixel = {
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
