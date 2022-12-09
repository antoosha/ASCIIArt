package models.pixels

class ASCIIPixel extends Pixel {

  private var brightness = 0
  private var pixel: Char = ' '

  def this(brightness: Int) {
    this()
    if (brightness < 0 || brightness > 255) {
      throw new IllegalArgumentException(s"Value of brightness has to be 0-255. Value of brightness is $brightness")
    }
    this.brightness = brightness
  }

  def getBrightness: Int = brightness

  def getPixel: Char = pixel

  def setPixel(char: Char): Unit = {
    pixel = char
  }

}
