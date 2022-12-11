package models.pixels

case class ASCIIPixel(private val pixel: Char = ' ') extends Pixel {

  def getPixel: Char = pixel

}
