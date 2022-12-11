package models.pixels

class GrayscalePixel extends Pixel {

  private var brightness = 0

  def this(brightness: Int) {

    this()
    if (brightness < 0 || brightness > 255) {
      throw new IllegalArgumentException(s"Value of brightness has to be 0-255. Value of brightness is $brightness")
    }
    this.brightness = brightness
  }

  def getBrightness: Int = brightness

}
