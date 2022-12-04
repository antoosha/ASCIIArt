package models.pixels

case class ASCIIPixel(private var brightness: Int) extends Pixel {

  private var pixel: Char = ' '

  def getBrightness: Int = brightness

  def getPixel: Char = pixel

}
