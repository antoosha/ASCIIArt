package business.converters.image

import business.filters.image.ImageFilter
import models.grids.pixel.GrayscaleGrid
import models.images.{GrayscaleImage, RGBImage}
import models.pixels.{GrayscalePixel, RGBPixel}

/**
 * Represents conversion from RGBImage to GrayscaleImage
 */
case class RGBToGrayscaleImageConverter() extends ImageConverter[RGBImage, GrayscaleImage] {

  var filters: Seq[ImageFilter[GrayscaleImage]] = Seq()

  /**
   * Converts RGBImage to GrayscaleImage
   *
   * @param item image to convert
   * @return converted image
   */
  override def convert(item: RGBImage): GrayscaleImage = {

    var grayscalePixelGrid: Seq[Seq[GrayscalePixel]] = Seq()

    //count brightness
    for (y <- 0 until item.getHeight) {
      var grayscalePixelRow = Seq[GrayscalePixel]()
      for (x <- 0 until item.getWidth) {
        grayscalePixelRow = grayscalePixelRow.appended(countBrightnessForRGBPixelToGrayscalePixel(item.getPixel(x, y)))
      }
      grayscalePixelGrid = grayscalePixelGrid.appended(grayscalePixelRow)
    }

    //apply all filters
    var resultGrayscaleImage: GrayscaleImage = GrayscaleImage(GrayscaleGrid(grayscalePixelGrid))
    for (i <- filters.indices) {
      resultGrayscaleImage = filters(i).apply(resultGrayscaleImage)
    }

    resultGrayscaleImage
  }

  /**
   * Counts brightness for RGBPixel via formula
   *
   * @param rgb pixel to convert
   * @return converted GrayscalePixel
   */
  private def countBrightnessForRGBPixelToGrayscalePixel(rgb: RGBPixel): GrayscalePixel = {

    var value: Double = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    if (value > 255) {
      value = 255
    } else if (value < 0) {
      value = 0
    }
    new GrayscalePixel(value.round.toInt)
  }

  /**
   * Adds filter to the list of filters to apply during conversion
   *
   * @param filter is filter to apply during conversion
   */
  def addFilter(filter: ImageFilter[GrayscaleImage]): Unit = {
    filters = filters.appended(filter)
  }
}
