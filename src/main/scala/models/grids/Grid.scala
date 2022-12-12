package models.grids

/**
 * Abstract data model of a grid
 *
 * @tparam T element of the grid
 */
trait Grid[T] {

  /**
   * Gets elements by x and y from the grid
   *
   * @param x
   * @param y
   * @return item at (x,y) position
   */
  def getElement(x: Int, y: Int): T

  /**
   * Gets height of the grid
   *
   * @return height of the grid
   */
  def getHeight: Int

  /**
   * Gets width of the grid
   *
   * @return width of the grid
   */
  def getWidth: Int

}
