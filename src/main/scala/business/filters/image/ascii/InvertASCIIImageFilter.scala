package business.filters.image.ascii

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel

class InvertASCIIImageFilter extends ImageFilter[ASCIIImage] {

  override def apply(image: ASCIIImage): ASCIIImage = {

    var invertedGrid = Seq[Seq[ASCIIPixel]]()
    for (y <- 0 until image.getHeight) {
      var invertedRow = Seq[ASCIIPixel]()
      for (x <- 0 until image.getWidth) {
        invertedRow = invertedRow.appended(new ASCIIPixel(255 - image.getPixel(x, y).getBrightness))
      }
      invertedGrid = invertedGrid.appended(invertedRow)
    }
    ASCIIImage(ASCIIGrid(invertedGrid))
  }
}
