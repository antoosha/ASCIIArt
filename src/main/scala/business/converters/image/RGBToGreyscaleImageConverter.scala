package business.converters.image

import business.filters.image.ImageFilter
import models.grids.pixel.GrayscaleGrid
import models.images.{GrayscaleImage, RGBImage}
import models.pixels.{GrayscalePixel, RGBPixel}

case class RGBToGreyscaleImageConverter() extends ImageConverter[RGBImage, GrayscaleImage] {

  var filters: Seq[ImageFilter[GrayscaleImage]] = Seq()

  override def convert(item: RGBImage): GrayscaleImage = {

    var greyscalePixelGrid: Seq[Seq[GrayscalePixel]] = Seq()

    //count brightness
    for (y <- 0 until item.getHeight) {
      var greyscalePixelRow = Seq[GrayscalePixel]()
      for (x <- 0 until item.getWidth) {
        greyscalePixelRow = greyscalePixelRow.appended(countBrightnessForRGBPixelToGreyscalePixel(item.getPixel(x, y)))
      }
      greyscalePixelGrid = greyscalePixelGrid.appended(greyscalePixelRow)
    }

    //apply all filters
    var resultGreyscaleImage: GrayscaleImage = GrayscaleImage(GrayscaleGrid(greyscalePixelGrid))
    for (i <- filters.indices) {
      resultGreyscaleImage = filters(i).apply(resultGreyscaleImage)
    }

    resultGreyscaleImage
  }

  private def countBrightnessForRGBPixelToGreyscalePixel(rgb: RGBPixel): GrayscalePixel = {

    var value = (0.3 * rgb.getRed) + (0.59 * rgb.getGreen) + (0.11 * rgb.getBlue)
    if (value > 255) {
      value = 255
    } else if (value < 0) {
      value = 0
    }
    new GrayscalePixel(value.toInt)
  }

  def addFilter(filter: ImageFilter[GrayscaleImage]): Unit = {
    filters = filters.appended(filter)
  }
}
