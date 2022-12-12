package business.filters.image.grayscale

import business.filters.image.ImageFilter
import models.Axis.{Axis, X, Y}
import models.grids.pixel.GrayscaleGrid
import models.images.GrayscaleImage
import models.pixels.GrayscalePixel

/**
 * Represents flipping filter
 *
 * @param axis by that to flip. Could be x or y
 */
class FlipGrayscaleImageFilter(private val axis: Axis) extends ImageFilter[GrayscaleImage] {

  /**
   * Applies flipping for an image
   *
   * @param image for apply filter
   * @return image after applying filter
   */
  override def apply(image: GrayscaleImage): GrayscaleImage = {
    axis match {
      case X => GrayscaleImage(flipByAxisX(image))
      case Y => GrayscaleImage(flipByAxisY(image))
    }
  }

  /**
   * Flipps by X axis
   *
   * @param image for apply filter
   * @return image after applying filter
   */
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

  /**
   * Flipps by Y axis
   *
   * @param image for apply filter
   * @return image after applying filter
   */
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
