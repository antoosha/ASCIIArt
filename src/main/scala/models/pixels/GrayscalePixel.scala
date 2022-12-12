package models.pixels

/**
 * Concrete data model of GrayscalePixel
 */
class GrayscalePixel extends Pixel {

  private var brightness = 0

  /**
   * Constructor for GrayscalePixel with checked required parameter
   *
   * @param brightness grayscale value
   */
  def this(brightness: Int) {

    this()
    if (brightness < 0 || brightness > 255) {
      throw new IllegalArgumentException(s"Value of brightness has to be 0-255. Value of brightness is $brightness")
    }
    this.brightness = brightness
  }

  def getBrightness: Int = brightness

}
