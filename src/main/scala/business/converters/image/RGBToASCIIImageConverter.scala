package business.converters.image

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.{ASCIIImage, RGBImage}
import models.pixels.{ASCIIPixel, RGBPixel}
import models.tables.ConversionTable
import models.tables.linear.PaulBrokesLinearConversionTable

import scala.collection.mutable.ListBuffer

case class RGBToASCIIImageConverter(private var conversionTable: ConversionTable[String, Char] = PaulBrokesLinearConversionTable()) extends ImageConverter[RGBImage, ASCIIImage] {

  var filters: ListBuffer[ImageFilter] = ListBuffer()

  override def convert(item: RGBImage): ASCIIImage = {
    val asciiGrid: ListBuffer[ListBuffer[ASCIIPixel]] = ListBuffer()

    for (y <- 0 until item.getHeight) {
      val asciiRow = ListBuffer[ASCIIPixel]()
      for (x <- 0 until item.getWidth) {
        asciiRow.append(convertRGBPixelToASCIIPixel(item.getPixel(x, y)))
      }
      asciiGrid.append(asciiRow)
    }
    ASCIIImage(ASCIIGrid(asciiGrid))
  }

  private def convertRGBPixelToASCIIPixel(rgb: RGBPixel): ASCIIPixel = {

    var value = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    if (value > 255) {
      value = 255
    } else if (value < 0) {
      value = 0
    }
    var asciiPixel: ASCIIPixel = ASCIIPixel(value.toInt)

    val greyscaleValue = (((conversionTable.getConversionTable.length - 1) * (asciiPixel.getBrightness / 255.0)) % conversionTable.getConversionTable.length).toInt
    asciiPixel.setPixel(conversionTable.getValue(greyscaleValue))
    asciiPixel
  }

  def setTable(conversionTable: ConversionTable[String, Char]): Unit = {
    this.conversionTable = conversionTable
  }

  def addFilter(filter: ImageFilter): Unit = {
    filters.append(filter)
  }
}
