package models.grids.pixel

import models.pixels.RGBPixel

/**
 * Concrete data model of the RGB pixels grid
 *
 * @param rgbGrid matrix of RGB pixels
 */
case class RGBGrid(private val rgbGrid: Seq[Seq[RGBPixel]]) extends PixelGrid[RGBPixel] {

  /**
   * Gets RGBixel by x and y from the grid
   *
   * @param x
   * @param y
   * @return RGBPixel at (x,y) position
   */
  override def getElement(x: Int, y: Int): RGBPixel = {

    if (x < 0 || x > getWidth || y < 0 || y > getHeight) {
      throw new IllegalStateException(s"Index is out of grid borders. Grid borders: ${this.getHeight}x${this.getWidth}")
    }
    rgbGrid(y)(x)
  }

  /**
   * Gets height of the grid
   *
   * @return height of the grid
   */
  override def getHeight: Int = {
    rgbGrid.length
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
      rgbGrid.head.length
    }
  }
}
