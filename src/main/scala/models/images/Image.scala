package models.images

import models.pixels.Pixel

/**
 * Abstract data model of image
 */
trait Image {

  /**
   * Gets pixel by it's (x,y) position in the image
   *
   * @param x
   * @param y
   * @return selected pixel
   */
  def getPixel(x: Int, y: Int): Pixel

  /**
   * Gets height of the image
   *
   * @return height of the image
   */
  def getHeight: Int

  /**
   * Gets width of the image
   *
   * @return width of the image
   */
  def getWidth: Int

}
