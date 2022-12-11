package models.images

import models.grids.pixel.ASCIIGrid
import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

class ASCIIImageTest extends FunSuite {

  test("Get height of the 0x0 image") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assert(0.equals(asciiImage.getHeight))
  }

  test("Get width of the 0x0 image") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assert(0.equals(asciiImage.getWidth))
  }

  test("Get height of the 1x2 image") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(ASCIIPixel('U'))
    pixelRow = pixelRow.appended(ASCIIPixel('U'))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assert(1.equals(asciiImage.getHeight))
  }

  test("Get width of the 1x2 image") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(ASCIIPixel('U'))
    pixelRow = pixelRow.appended(ASCIIPixel('U'))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assert(2.equals(asciiImage.getWidth))
  }

  test("Get pixel by correct indexes x=0, y=0") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    val rgbPixel: ASCIIPixel = ASCIIPixel('U')
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    assert(rgbPixel.equals(asciiImage.getPixel(0, 0)))
  }

  test("Get pixel by correct indexes x=1, y=0") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    val rgbPixel: ASCIIPixel = ASCIIPixel('U')
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    assert(rgbPixel.equals(asciiImage.getPixel(1, 0)))
  }

  test("Get pixel by incorrect indexes") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assertThrows[IllegalStateException](asciiImage.getPixel(1, 1))
  }
}
