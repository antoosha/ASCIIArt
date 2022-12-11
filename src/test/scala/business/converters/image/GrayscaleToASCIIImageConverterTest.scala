package business.converters.image

import models.grids.pixel.GrayscaleGrid
import models.images.{ASCIIImage, GrayscaleImage}
import models.pixels.{ASCIIPixel, GrayscalePixel}
import models.tables.nonlinear.SimpleNonLinearConversionTable
import org.scalatest.FunSuite

class GrayscaleToASCIIImageConverterTest extends FunSuite {


  test("Convert correct square image 1x1 with default table, checking height") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(1.equals(convertedImage.getHeight))
  }

  test("Convert correct square image 1x1 with default table, checking width") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(1.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x1 with default table, checking char value") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val asciiPixel: ASCIIPixel = ASCIIPixel('$')

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(asciiPixel.getPixel.equals(convertedImage.getPixel(0, 0).getPixel))
  }

  test("Convert correct square image 1x2 with default table, checking height") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(1.equals(convertedImage.getHeight))
  }

  test("Convert correct square image 1x2 with default table, checking width") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(2.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x2 with default table, checking value of pixel (0;0)") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val asciiPixel: ASCIIPixel = ASCIIPixel('$')

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(asciiPixel.getPixel.equals(convertedImage.getPixel(0, 0).getPixel))
  }

  test("Convert correct square image 1x2 with default table, checking value of pixel (1;0)") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(1)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val asciiPixel2: ASCIIPixel = ASCIIPixel('$')

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(asciiPixel2.getPixel.equals(convertedImage.getPixel(1, 0).getPixel))
  }

  test("Convert incorrect image 0x0 with default table, checking height") {
    val pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(0.equals(convertedImage.getHeight))
  }

  test("Convert incorrect image 0x0 with default table, checking width") {
    val pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(0.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x3 with nonlinear table, checking height") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(100)
    val greyscalePixel3: GrayscalePixel = new GrayscalePixel(101)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)
    pixelRow = pixelRow.appended(greyscalePixel3)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter(new SimpleNonLinearConversionTable)

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(1.equals(convertedImage.getHeight))
  }

  test("Convert correct square image 1x3 with nonlinear table, , checking width") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(100)
    val greyscalePixel3: GrayscalePixel = new GrayscalePixel(101)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)
    pixelRow = pixelRow.appended(greyscalePixel3)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter(new SimpleNonLinearConversionTable)

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(3.equals(convertedImage.getWidth))
  }

  test("Convert correct square image 1x3 with nonlinear table, checking value of pixel (0;0)") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(100)
    val greyscalePixel3: GrayscalePixel = new GrayscalePixel(101)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)
    pixelRow = pixelRow.appended(greyscalePixel3)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter(new SimpleNonLinearConversionTable)

    val asciiPixel: ASCIIPixel = ASCIIPixel('$')

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(asciiPixel.getPixel.equals(convertedImage.getPixel(0, 0).getPixel))
  }

  test("Convert correct square image 1x3 with nonlinear table, checking value of pixel (1;0)") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(100)
    val greyscalePixel3: GrayscalePixel = new GrayscalePixel(101)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)
    pixelRow = pixelRow.appended(greyscalePixel3)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter(new SimpleNonLinearConversionTable)

    val asciiPixel2: ASCIIPixel = ASCIIPixel('$')

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(asciiPixel2.getPixel.equals(convertedImage.getPixel(1, 0).getPixel))
  }

  test("Convert correct square image 1x3 with nonlinear table, checking value of pixel (2;0)") {

    val greyscalePixel: GrayscalePixel = new GrayscalePixel(1)
    val greyscalePixel2: GrayscalePixel = new GrayscalePixel(100)
    val greyscalePixel3: GrayscalePixel = new GrayscalePixel(101)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(greyscalePixel)
    pixelRow = pixelRow.appended(greyscalePixel2)
    pixelRow = pixelRow.appended(greyscalePixel3)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val greyscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val greyscaleImage: GrayscaleImage = GrayscaleImage(greyscalePixelGrid)
    val converter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter(new SimpleNonLinearConversionTable)

    val asciiPixel3: ASCIIPixel = ASCIIPixel('@')

    val convertedImage: ASCIIImage = converter.convert(greyscaleImage)
    assert(asciiPixel3.getPixel.equals(convertedImage.getPixel(2, 0).getPixel))
  }
}
