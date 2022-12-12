package models.images

import models.grids.pixel.GrayscaleGrid
import models.pixels.GrayscalePixel

/**
 * Concrete data model of GrayscaleImage
 *
 * @param grayscaleGrid grid of GrayscalePixels of the image
 */
case class GrayscaleImage(private val grayscaleGrid: GrayscaleGrid) extends Image {

  /**
   * Gets pixel by it's (x,y) position in the image
   *
   * @param x
   * @param y
   * @return selected pixel
   */
  override def getPixel(x: Int, y: Int): GrayscalePixel = {
    grayscaleGrid.getElement(x, y)
  }

  /**
   * Gets height of the image
   *
   * @return height of the image
   */
  override def getHeight: Int = {
    grayscaleGrid.getHeight
  }

  /**
   * Gets width of the image
   *
   * @return width of the image
   */
  override def getWidth: Int = {
    grayscaleGrid.getWidth
  }
}
