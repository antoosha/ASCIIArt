package models.pixels

case class ASCIIPixel(private var brightness: Int) extends Pixel {
  def getBrightness: Int = brightness
}
