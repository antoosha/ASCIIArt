package business.filters.image.ascii

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel

class FlipASCIIImageFilter(private val axis: String) extends ImageFilter[ASCIIImage] {

  override def apply(image: ASCIIImage): ASCIIImage = {

    var flippedGrid = Seq[Seq[ASCIIPixel]]()
    if (axis.toLowerCase() == "x") {
      for (y <- (image.getHeight - 1) to 0 by -1) {
        var flippedRow = Seq[ASCIIPixel]()
        for (x <- 0 until image.getWidth) {
          flippedRow = flippedRow.appended(image.getPixel(x, y))
        }
        flippedGrid = flippedGrid.appended(flippedRow)
      }
    } else if (axis.toLowerCase() == "y") {
      for (y <- 0 until image.getHeight) {
        var flippedRow = Seq[ASCIIPixel]()
        for (x <- (image.getWidth - 1) to 0 by -1) {
          flippedRow = flippedRow.appended(image.getPixel(x, y))
        }
        flippedGrid = flippedGrid.appended(flippedRow)
      }
    } else {
      throw new IllegalStateException(s"There is no possibility to flip by '$axis', only 'x' and 'y' supported.")
    }

    ASCIIImage(ASCIIGrid(flippedGrid))
  }
}
