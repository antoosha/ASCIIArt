package models.grids.pixel

import models.pixels.ASCIIPixel

/**
 * Concrete data model of the ACIIPixels grid
 *
 * @param asciiGrid matrix of ASCIIPixels
 */
case class ASCIIGrid(private val asciiGrid: Seq[Seq[ASCIIPixel]]) extends PixelGrid[ASCIIPixel] {

  /**
   * Gets ASCIIPixel from the grid
   *
   * @param x
   * @param y
   * @return ASCIIPixel at (x,y) position
   */
  override def getElement(x: Int, y: Int): ASCIIPixel = {

    if (x < 0 || x > getWidth || y < 0 || y > getHeight) {
      throw new IllegalStateException(s"Index is out of grid borders. Grid borders: ${this.getHeight}x${this.getWidth}")
    }
    asciiGrid(y)(x)
  }

  /**
   * Gets width of the grid
   *
   * @return width of the grid
   */
  override def getWidth: Int = {
    if (getHeight == 0) {
      0
    }
    else {
      asciiGrid.head.length
    }
  }

  /**
   * Gets height of the grid
   *
   * @return height of the grid
   */
  override def getHeight: Int = {
    asciiGrid.length
  }
}
