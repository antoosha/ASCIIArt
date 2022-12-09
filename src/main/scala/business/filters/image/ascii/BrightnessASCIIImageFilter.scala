package business.filters.image.ascii

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel

class BrightnessASCIIImageFilter(private val value: String) extends ImageFilter[ASCIIImage] {

  override def apply(image: ASCIIImage): ASCIIImage = {

    var changedGrid = Seq[Seq[ASCIIPixel]]()
    for (y <- 0 until image.getHeight) {
      var changedRow = Seq[ASCIIPixel]()
      for (x <- 0 until image.getWidth) {
        var newBrightness: Int = Integer.valueOf(value) + image.getPixel(x, y).getBrightness
        if (newBrightness > 255) {
          newBrightness = 255
        }
        else if (newBrightness < 0) {
          newBrightness = 0
        }
        changedRow = changedRow.appended(ASCIIPixel(newBrightness))
      }
      changedGrid = changedGrid.appended(changedRow)
    }
    ASCIIImage(ASCIIGrid(changedGrid))
  }
}
