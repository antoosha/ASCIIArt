package business.filters.image.grayscale

import business.filters.image.ImageFilter
import models.Axis.{Axis, X, Y}
import models.grids.pixel.GrayscaleGrid
import models.images.GrayscaleImage
import models.pixels.GrayscalePixel

class FlipGrayscaleImageFilter(private val axis: Axis) extends ImageFilter[GrayscaleImage] {

  override def apply(image: GrayscaleImage): GrayscaleImage = {
    axis match {
      case X => GrayscaleImage(flipByAxisX(image))
      case Y => GrayscaleImage(flipByAxisY(image))
    }
  }

  private def flipByAxisX(image: GrayscaleImage): GrayscaleGrid = {

    var flippedGrid = Seq[Seq[GrayscalePixel]]()
    for (y <- (image.getHeight - 1) to 0 by -1) {
      var flippedRow = Seq[GrayscalePixel]()
      for (x <- 0 until image.getWidth) {
        flippedRow = flippedRow.appended(image.getPixel(x, y))
      }
      flippedGrid = flippedGrid.appended(flippedRow)
    }
    GrayscaleGrid(flippedGrid)
  }

  private def flipByAxisY(image: GrayscaleImage): GrayscaleGrid = {

    var flippedGrid = Seq[Seq[GrayscalePixel]]()
    for (y <- 0 until image.getHeight) {
      var flippedRow = Seq[GrayscalePixel]()
      for (x <- (image.getWidth - 1) to 0 by -1) {
        flippedRow = flippedRow.appended(image.getPixel(x, y))
      }
      flippedGrid = flippedGrid.appended(flippedRow)
    }
    GrayscaleGrid(flippedGrid)
  }
}
