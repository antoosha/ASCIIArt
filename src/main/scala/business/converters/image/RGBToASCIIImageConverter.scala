package business.converters.image

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.{ASCIIImage, RGBImage}
import models.pixels.{ASCIIPixel, RGBPixel}
import models.tables.ConversionTable
import models.tables.linear.PaulBourkesLinearConversionTable

case class RGBToASCIIImageConverter(private var convTable: ConversionTable[String, Char] = PaulBourkesLinearConversionTable()) extends ImageConverter[RGBImage, ASCIIImage] {

  var filters: Seq[ImageFilter[ASCIIImage]] = Seq()

  override def convert(item: RGBImage): ASCIIImage = {

    var asciiGrid: Seq[Seq[ASCIIPixel]] = Seq()

    //count brightness
    for (y <- 0 until item.getHeight) {
      var asciiRow = Seq[ASCIIPixel]()
      for (x <- 0 until item.getWidth) {
        asciiRow = asciiRow.appended(countBrightnessForRGBPixelToASCIIPixel(item.getPixel(x, y)))
      }
      asciiGrid = asciiGrid.appended(asciiRow)
    }

    //apply all filters
    var resultASCIIImage: ASCIIImage = ASCIIImage(ASCIIGrid(asciiGrid))
    for (i <- filters.indices) {
      resultASCIIImage = filters(i).apply(resultASCIIImage)
    }

    //count char value
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getWidth) {
        countValueFromBrightnessForASCIIPixel(resultASCIIImage.getPixel(x, y))
      }
    }

    resultASCIIImage
  }

  private def countBrightnessForRGBPixelToASCIIPixel(rgb: RGBPixel): ASCIIPixel = {

    var value = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    if (value > 255) {
      value = 255
    } else if (value < 0) {
      value = 0
    }
    new ASCIIPixel(value.toInt)
  }

  private def countValueFromBrightnessForASCIIPixel(asciiPixel: ASCIIPixel): Unit = {

    var greyscaleValue = 0
    if (convTable.offset == 0) {
      greyscaleValue = ((convTable.getTableValues.length * (asciiPixel.getBrightness / 256.0)) % convTable.getTableValues.length).toInt
    } else if (asciiPixel.getBrightness > convTable.offset) {
      greyscaleValue = (((convTable.getTableValues.length - 1) * ((asciiPixel.getBrightness - convTable.offset) / (256.0 - convTable.offset)))
        % convTable.getTableValues.length).toInt + 1
    }
    asciiPixel.setPixel(convTable.getValue(greyscaleValue))
  }

  def setTable(conversionTable: ConversionTable[String, Char]): Unit = {
    this.convTable = conversionTable
  }

  def addFilter(filter: ImageFilter[ASCIIImage]): Unit = {
    filters = filters.appended(filter)
  }
}
