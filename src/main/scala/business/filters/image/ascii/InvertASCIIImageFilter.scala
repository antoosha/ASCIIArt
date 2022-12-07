package business.filters.image.ascii

import business.filters.image.ImageFilter
import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel

import scala.collection.mutable.ListBuffer

class InvertASCIIImageFilter extends ImageFilter[ASCIIImage] {

  override def apply(image: ASCIIImage): ASCIIImage = {

    val invertedGrid = ListBuffer[ListBuffer[ASCIIPixel]]()
    for (y <- 0 until image.getHeight) {
      val invertedRow = ListBuffer[ASCIIPixel]()
      for (x <- 0 until image.getWidth) {
        invertedRow.append(ASCIIPixel(255 - image.getPixel(x, y).getBrightness))
      }
      invertedGrid.append(invertedRow)
    }
    ASCIIImage(ASCIIGrid(invertedGrid))
  }
}
