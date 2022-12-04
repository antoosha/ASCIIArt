package models.pixels

case class RGBPixel() extends Pixel {
  private var r: Int = -1
  private var g: Int = -1
  private var b: Int = -1

  def this(r: Int, g: Int, b: Int) {
    this()
    if (r > 255) {
      throw new IllegalStateException(s"Bad value of red color: $r. Color value has to have value 0-255.")
    }
    else if (g > 255) {
      throw new IllegalStateException(s"Bad value of green color: $r. Color value has to have value 0-255.")
    }
    else if (b > 255) {
      throw new IllegalStateException(s"Bad value of blue color: $r. Color value has to have value 0-255.")
    }
    this.r = r
    this.g = g
    this.b = b
  }
}
