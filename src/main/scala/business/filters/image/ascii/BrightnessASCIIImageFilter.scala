package business.filters.image.ascii

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel

import scala.collection.mutable.ListBuffer

class BrightnessASCIIImageFilter(private val value: String) extends ImageFilter[ASCIIImage] {

  override def apply(image: ASCIIImage): ASCIIImage = {

    val changedGrid = ListBuffer[ListBuffer[ASCIIPixel]]()
    for (y <- 0 until image.getHeight) {
      val changedRow = ListBuffer[ASCIIPixel]()
      for (x <- 0 until image.getWidth) {
        var newBrightness: Int = Integer.valueOf(value) + image.getPixel(x, y).getBrightness
        if (newBrightness > 255) {
          newBrightness = 255
        }
        else if (newBrightness < 0) {
          newBrightness = 0
        }
        changedRow.append(ASCIIPixel(newBrightness))
      }
      changedGrid.append(changedRow)
    }
    ASCIIImage(ASCIIGrid(changedGrid))
  }
}
