package models.pixels

/**
 * Concrete data model of RGBPixel
 */
class RGBPixel extends Pixel {

  private var r: Int = -1
  private var g: Int = -1
  private var b: Int = -1

  /**
   * Constructor of RGBPixel with required checked values
   *
   * @param r
   * @param g
   * @param b
   */
  def this(r: Int, g: Int, b: Int) {
    this()
    if (r < 0 || r > 255) {
      throw new IllegalStateException(s"Bad value of red color: $r. Color value has to have value 0-255.")
    }
    else if (g < 0 || g > 255) {
      throw new IllegalStateException(s"Bad value of green color: $r. Color value has to have value 0-255.")
    }
    else if (b < 0 || b > 255) {
      throw new IllegalStateException(s"Bad value of blue color: $r. Color value has to have value 0-255.")
    }
    this.r = r
    this.g = g
    this.b = b
  }

  def getRed: Int = r

  def getGreen: Int = g

  def getBlue: Int = b

}
