package business.converters.image

import models.grids.pixel.ASCIIGrid
import models.images.{ASCIIImage, GrayscaleImage}
import models.pixels.{ASCIIPixel, GrayscalePixel}
import models.tables.ConversionTable
import models.tables.linear.PaulBourkesLinearConversionTable

/**
 * Represents conversion from GrayscaleImage to ASCIIImage using conversion table
 *
 * @param convTable
 */
class GrayscaleToASCIIImageConverter(private var convTable: ConversionTable[String, Char] = PaulBourkesLinearConversionTable()) extends ImageConverter[GrayscaleImage, ASCIIImage] {

  /**
   * Converts GrayscaleImage to ASCIIImage
   *
   * @param item to convert
   * @return converted item
   */
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

  /**
   * Converts GrayscalePixel to ASCIIPixel
   * Counts ascii character from brightness value using formula
   *
   * @param grayscalePixel pixel
   * @return
   */
  private def countValueFromBrightnessForASCIIPixel(grayscalePixel: GrayscalePixel): ASCIIPixel = {

    var idx: Int = 0
    if (convTable.offset == 0) {
      idx = ((convTable.getTableValues.length * (grayscalePixel.getBrightness / 256.0)) % convTable.getTableValues.length).toInt
    } else if (grayscalePixel.getBrightness > convTable.offset) {
      idx = (((convTable.getTableValues.length - 1) * ((grayscalePixel.getBrightness - convTable.offset) / (256.0 - convTable.offset)))
        % convTable.getTableValues.length).toInt + 1
    }

    ASCIIPixel(convTable.getValue(idx))
  }

  /**
   * Sets defined table
   *
   * @param convTable is defined table to set
   */
  def setTable(convTable: ConversionTable[String, Char]): Unit = {
    this.convTable = convTable
  }
}
