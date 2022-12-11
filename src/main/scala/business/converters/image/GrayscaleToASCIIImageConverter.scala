package business.converters.image

import models.grids.pixel.ASCIIGrid
import models.images.{ASCIIImage, GrayscaleImage}
import models.pixels.{ASCIIPixel, GrayscalePixel}
import models.tables.ConversionTable
import models.tables.linear.PaulBourkesLinearConversionTable

class GrayscaleToASCIIImageConverter(private var convTable: ConversionTable[String, Char] = PaulBourkesLinearConversionTable()) extends ImageConverter[GrayscaleImage, ASCIIImage] {

  override def convert(item: GrayscaleImage): ASCIIImage = {

    var asciiPixelGrid: Seq[Seq[ASCIIPixel]] = Seq[Seq[ASCIIPixel]]()
    for (y <- 0 until item.getHeight) {
      var asciiPixelRow: Seq[ASCIIPixel] = Seq[ASCIIPixel]()
      for (x <- 0 until item.getWidth) {
        asciiPixelRow = asciiPixelRow.appended(countValueFromBrightnessForASCIIPixel(item.getPixel(x, y)))
      }
      asciiPixelGrid = asciiPixelGrid.appended(asciiPixelRow)
    }

    ASCIIImage(ASCIIGrid(asciiPixelGrid))
  }

  private def countValueFromBrightnessForASCIIPixel(greyscalePixel: GrayscalePixel): ASCIIPixel = {

    var idx: Int = 0
    if (convTable.offset == 0) {
      idx = ((convTable.getTableValues.length * (greyscalePixel.getBrightness / 256.0)) % convTable.getTableValues.length).toInt
    } else if (greyscalePixel.getBrightness > convTable.offset) {
      idx = (((convTable.getTableValues.length - 1) * ((greyscalePixel.getBrightness - convTable.offset) / (256.0 - convTable.offset)))
        % convTable.getTableValues.length).toInt + 1
    }

    ASCIIPixel(convTable.getValue(idx))
  }

  def setTable(convTable: ConversionTable[String, Char]): Unit = {
    this.convTable = convTable
  }
}
