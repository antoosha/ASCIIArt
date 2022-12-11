package business.converters.image

import models.grids.pixel.RGBGrid
import models.images.{GrayscaleImage, RGBImage}
import models.pixels.{GrayscalePixel, RGBPixel}
import org.scalatest.FunSuite

class RGBToGrayscaleImageConverterTest extends FunSuite {

  test("Convert correct square image 1x1, checking height") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(1.equals(convertedImage.getHeight))
  }
  test("Convert correct square image 1x1, checking width") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(1.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x1, checking brightness value") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val grayscalePixel: GrayscalePixel = new GrayscalePixel(1)

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(grayscalePixel.getBrightness.equals(convertedImage.getPixel(0, 0).getBrightness))
  }

  test("Convert correct square image 1x2, checking height") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbPixel2: RGBPixel = new RGBPixel(100, 100, 100)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel2)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(1.equals(convertedImage.getHeight))
  }

  test("Convert correct square image 1x2, checking width") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbPixel2: RGBPixel = new RGBPixel(100, 100, 100)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel2)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(2.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x2, checking value of pixel (0;0)") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbPixel2: RGBPixel = new RGBPixel(100, 100, 100)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel2)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val grayscalePixel: GrayscalePixel = new GrayscalePixel(1)

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(grayscalePixel.getBrightness.equals(convertedImage.getPixel(0, 0).getBrightness))
  }

  test("Convert correct square image 1x2, checking value of pixel (1;0)") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbPixel2: RGBPixel = new RGBPixel(100, 100, 100)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel2)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(100)

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(grayscalePixel2.getBrightness.equals(convertedImage.getPixel(1, 0).getBrightness))
  }

  test("Convert incorrect image 0x0, checking height") {
    val pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(0.equals(convertedImage.getHeight))
  }

  test("Convert incorrect image 0x0, checking width") {
    val pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()

    val convertedImage: GrayscaleImage = converter.convert(rgbImage)
    assert(0.equals(convertedImage.getWidth))
  }
}
