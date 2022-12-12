package models.images

import models.grids.pixel.RGBGrid
import models.pixels.RGBPixel

/**
 * Concrete data model of RGB image
 *
 * @param rgbGrid grid of RGBPixels of the image
 */
case class RGBImage(private val rgbGrid: RGBGrid) extends Image {

  /**
   * Gets pixel by it's (x,y) position in the image
   *
   * @param x
   * @param y
   * @return selected pixel
   */
  override def getPixel(x: Int, y: Int): RGBPixel = {
    rgbGrid.getElement(x, y)
  }

  /**
   * Gets height of the image
   *
   * @return height of the image
   */
  override def getHeight: Int = {
    rgbGrid.getHeight
  }

  /**
   * Gets width of the image
   *
   * @return width of the image
   */
  override def getWidth: Int = {
    rgbGrid.getWidth
  }
}
