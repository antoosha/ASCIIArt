package business.filters.image.grayscale

import business.filters.image.ImageFilter
import models.grids.pixel.GrayscaleGrid
import models.images.GrayscaleImage
import models.pixels.GrayscalePixel


class BrightnessGrayscaleImageFilter(private val value: String) extends ImageFilter[GrayscaleImage] {

  override def apply(image: GrayscaleImage): GrayscaleImage = {

    var changedGrid = Seq[Seq[GrayscalePixel]]()
    for (y <- 0 until image.getHeight) {
      var changedRow = Seq[GrayscalePixel]()
      for (x <- 0 until image.getWidth) {
        var newBrightness: Int = Integer.valueOf(value) + image.getPixel(x, y).getBrightness
        if (newBrightness > 255) {
          newBrightness = 255
        }
        else if (newBrightness < 0) {
          newBrightness = 0
        }
        changedRow = changedRow.appended(new GrayscalePixel(newBrightness))
      }
      changedGrid = changedGrid.appended(changedRow)
    }
    GrayscaleImage(GrayscaleGrid(changedGrid))
  }
}
