package business.filters.image.grayscale

import business.filters.image.ImageFilter
import models.grids.pixel.GrayscaleGrid
import models.images.GrayscaleImage
import models.pixels.GrayscalePixel

class InvertGrayscaleImageFilter extends ImageFilter[GrayscaleImage] {

  override def apply(image: GrayscaleImage): GrayscaleImage = {

    var invertedGrid = Seq[Seq[GrayscalePixel]]()
    for (y <- 0 until image.getHeight) {
      var invertedRow = Seq[GrayscalePixel]()
      for (x <- 0 until image.getWidth) {
        invertedRow = invertedRow.appended(new GrayscalePixel(255 - image.getPixel(x, y).getBrightness))
      }
      invertedGrid = invertedGrid.appended(invertedRow)
    }
    GrayscaleImage(GrayscaleGrid(invertedGrid))
  }
}
