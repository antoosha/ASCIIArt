package models.grids.pixel

import models.pixels.GrayscalePixel

/**
 * Concrete data model of GrayscalePixels grid
 *
 * @param grayscaleGrid matrix of Graysclae pixels
 */
case class GrayscaleGrid(private val grayscaleGrid: Seq[Seq[GrayscalePixel]]) extends PixelGrid[GrayscalePixel] {

  /**
   * Gets GrayscalePixel from the grid
   *
   * @param x
   * @param y
   * @return GrayscalePixel at (x,y) position
   */
  override def getElement(x: Int, y: Int): GrayscalePixel = {

    if (x < 0 || x > getWidth || y < 0 || y > getHeight) {
      throw new IllegalStateException(s"Index is out of grid borders. Grid borders: ${this.getHeight}x${this.getWidth}")
    }
    grayscaleGrid(y)(x)
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
      grayscaleGrid.head.length
    }
  }

  /**
   * Gets height of the grid
   *
   * @return height of the grid
   */
  override def getHeight: Int = {
    grayscaleGrid.length
  }
}
