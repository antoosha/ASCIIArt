package models.images

import models.grids.pixel.ASCIIGrid
import models.pixels.ASCIIPixel

/**
 * Concrete data model of ASCIIImage
 *
 * @param asciiGrid grid of ASCIIPixels of the image
 */
case class ASCIIImage(private val asciiGrid: ASCIIGrid) extends Image {

  /**
   * Gets pixel by it's (x,y) position in the image
   *
   * @param x
   * @param y
   * @return selected pixel
   */
  override def getPixel(x: Int, y: Int): ASCIIPixel = {
    asciiGrid.getElement(x, y)
  }

  /**
   * Gets height of the image
   *
   * @return height of the image
   */
  override def getHeight: Int = {
    asciiGrid.getHeight
  }

  /**
   * Gets width of the image
   *
   * @return width of the image
   */
  override def getWidth: Int = {
    asciiGrid.getWidth
  }
}
