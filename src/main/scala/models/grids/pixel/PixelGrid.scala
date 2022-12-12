package models.grids.pixel

import models.grids.Grid
import models.pixels.Pixel

/**
 * Abstract data model of a grid of pixels
 *
 * @tparam T pixel in the grid
 */
trait PixelGrid[T <: Pixel] extends Grid[Pixel] {

  /**
   * Gets pixel by x and y from the grid
   *
   * @param x
   * @param y
   * @return pixel at (x,y) position
   */
  override def getElement(x: Int, y: Int): Pixel

  /**
   * Gets height of the grid
   *
   * @return height of the grid
   */
  override def getHeight: Int

  /**
   * Gets width of the grid
   *
   * @return width of the grid
   */
  override def getWidth: Int
}
