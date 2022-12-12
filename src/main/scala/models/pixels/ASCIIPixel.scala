package models.pixels

/**
 * Concrete data model of ASCIIPixel
 *
 * @param pixel
 */
case class ASCIIPixel(private val pixel: Char = ' ') extends Pixel {

  /**
   * Gets char value of the pixel
   *
   * @return char value of the pixel
   */
  def getPixel: Char = pixel

}
