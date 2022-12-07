package business.filters.image.ascii

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel

import scala.collection.mutable.ListBuffer

class FlipASCIIImageFilter(private val axis: String) extends ImageFilter[ASCIIImage] {

  override def apply(image: ASCIIImage): ASCIIImage = {

    val flippedGrid = ListBuffer[ListBuffer[ASCIIPixel]]()
    if (axis.toLowerCase() == "x") {
      for (y <- (image.getHeight - 1) to 0 by -1) {
        val flippedRow = ListBuffer[ASCIIPixel]()
        for (x <- 0 until image.getWidth) {
          flippedRow.append(image.getPixel(x, y))
        }
        flippedGrid.append(flippedRow)
      }
    } else if (axis.toLowerCase() == "y") {
      for (y <- 0 until image.getHeight) {
        val flippedRow = ListBuffer[ASCIIPixel]()
        for (x <- (image.getWidth - 1) to 0 by -1) {
          flippedRow.append(image.getPixel(x, y))
        }
        flippedGrid.append(flippedRow)
      }
    } else {
      throw new IllegalStateException(s"There is no possibility to flip by '$axis', only 'x' and 'y' supported.")
    }

    ASCIIImage(ASCIIGrid(flippedGrid))
  }
}
