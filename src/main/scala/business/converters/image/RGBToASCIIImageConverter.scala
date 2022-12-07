package business.converters.image

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.{ASCIIImage, RGBImage}
import models.pixels.{ASCIIPixel, RGBPixel}
import models.tables.ConversionTable
import models.tables.linear.PaulBrokesLinearConversionTable

import scala.collection.mutable.ListBuffer

case class RGBToASCIIImageConverter(private var convTable: ConversionTable[String, Char] = PaulBrokesLinearConversionTable()) extends ImageConverter[RGBImage, ASCIIImage] {

  var filters: ListBuffer[ImageFilter[ASCIIImage]] = ListBuffer()

  override def convert(item: RGBImage): ASCIIImage = {
    val asciiGrid: ListBuffer[ListBuffer[ASCIIPixel]] = ListBuffer()

    for (y <- 0 until item.getHeight) {
      val asciiRow = ListBuffer[ASCIIPixel]()
      for (x <- 0 until item.getWidth) {
        asciiRow.append(convertRGBPixelToASCIIPixel(item.getPixel(x, y)))
      }
      asciiGrid.append(asciiRow)
    }

    //apply all filters
    var resultASCIIImage: ASCIIImage = ASCIIImage(ASCIIGrid(asciiGrid))
    for (i <- filters.indices) {
      resultASCIIImage = filters(i).apply(resultASCIIImage)
    }
    resultASCIIImage
  }

  private def convertRGBPixelToASCIIPixel(rgb: RGBPixel): ASCIIPixel = {

    var value = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    if (value > 255) {
      value = 255
    } else if (value < 0) {
      value = 0
    }
    val asciiPixel: ASCIIPixel = ASCIIPixel(value.toInt)

    var greyscaleValue = 0
    if (convTable.offset == 0) {
      greyscaleValue = ((convTable.getTableValues.length * ((asciiPixel.getBrightness) / 256.0)) % convTable.getTableValues.length).toInt
    } else if (asciiPixel.getBrightness > convTable.offset) {
      greyscaleValue = (((convTable.getTableValues.length - 1) * ((asciiPixel.getBrightness - convTable.offset) / (256.0 - convTable.offset)))
        % convTable.getTableValues.length).toInt + 1
    }
    asciiPixel.setPixel(convTable.getValue(greyscaleValue))
    asciiPixel
  }

  def setTable(conversionTable: ConversionTable[String, Char]): Unit = {
    this.convTable = conversionTable
  }

  def addFilter(filter: ImageFilter[ASCIIImage]): Unit = {
    filters.append(filter)
  }
}
