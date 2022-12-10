package business.converters.image

import models.grids.RGBGrid
import models.images.{ASCIIImage, RGBImage}
import models.pixels.{ASCIIPixel, RGBPixel}
import models.tables.nonlinear.SimpleNonLinearConversionTable
import org.scalatest.FunSuite

class RGBToASCIIImageConverterTest extends FunSuite {

  test("Convert correct square image 1x1 with default table") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToASCIIImageConverter = RGBToASCIIImageConverter()

    val asciiPixel: ASCIIPixel = new ASCIIPixel(0)
    asciiPixel.setPixel('$')

    val convertedImage: ASCIIImage = converter.convert(rgbImage)
    assert(1.equals(convertedImage.getHeight))
    assert(1.equals(convertedImage.getWidth))
    assert(asciiPixel.getBrightness.equals(convertedImage.getPixel(0, 0).getBrightness))
    assert(asciiPixel.getPixel.equals(convertedImage.getPixel(0, 0).getPixel))
  }

  test("Convert correct square image 1x2 with default table") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbPixel2: RGBPixel = new RGBPixel(100, 100, 100)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel2)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToASCIIImageConverter = RGBToASCIIImageConverter()

    val asciiPixel: ASCIIPixel = new ASCIIPixel(0)
    asciiPixel.setPixel('$')
    val asciiPixel2: ASCIIPixel = new ASCIIPixel(100)
    asciiPixel2.setPixel('U')

    val convertedImage: ASCIIImage = converter.convert(rgbImage)
    assert(1.equals(convertedImage.getHeight))
    assert(2.equals(convertedImage.getWidth))
    assert(asciiPixel.getBrightness.equals(convertedImage.getPixel(0, 0).getBrightness))
    assert(asciiPixel.getPixel.equals(convertedImage.getPixel(0, 0).getPixel))
    assert(asciiPixel2.getBrightness.equals(convertedImage.getPixel(1, 0).getBrightness))
    assert(asciiPixel2.getPixel.equals(convertedImage.getPixel(1, 0).getPixel))
  }

  test("Convert incorrect image 0x0 with default table") {
    val pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToASCIIImageConverter = RGBToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(rgbImage)
    assert(0.equals(convertedImage.getHeight))
    assert(0.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x3 with nonlinear table") {

    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    val rgbPixel2: RGBPixel = new RGBPixel(100, 100, 100)
    val rgbPixel3: RGBPixel = new RGBPixel(110, 110, 110)
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel2)
    pixelRow = pixelRow.appended(rgbPixel3)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    val converter: RGBToASCIIImageConverter = RGBToASCIIImageConverter(SimpleNonLinearConversionTable())

    val asciiPixel: ASCIIPixel = new ASCIIPixel(0)
    asciiPixel.setPixel('$')
    val asciiPixel2: ASCIIPixel = new ASCIIPixel(100)
    asciiPixel2.setPixel('$')
    val asciiPixel3: ASCIIPixel = new ASCIIPixel(109)
    asciiPixel3.setPixel('8')

    val convertedImage: ASCIIImage = converter.convert(rgbImage)
    assert(1.equals(convertedImage.getHeight))
    assert(3.equals(convertedImage.getWidth))
    assert(asciiPixel.getBrightness.equals(convertedImage.getPixel(0, 0).getBrightness))
    assert(asciiPixel.getPixel.equals(convertedImage.getPixel(0, 0).getPixel))
    assert(asciiPixel2.getBrightness.equals(convertedImage.getPixel(1, 0).getBrightness))
    assert(asciiPixel2.getPixel.equals(convertedImage.getPixel(1, 0).getPixel))
    assert(asciiPixel3.getBrightness.equals(convertedImage.getPixel(2, 0).getBrightness))
    assert(asciiPixel3.getPixel.equals(convertedImage.getPixel(2, 0).getPixel))
  }
}
