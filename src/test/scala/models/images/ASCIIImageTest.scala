package models.images

import models.grids.ASCIIGrid
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
    pixelRow = pixelRow.appended(new ASCIIPixel(100))
    pixelRow = pixelRow.appended(new ASCIIPixel(100))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assert(1.equals(asciiImage.getHeight))
  }

  test("Get width of the 1x2 image") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(new ASCIIPixel(100))
    pixelRow = pixelRow.appended(new ASCIIPixel(100))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assert(2.equals(asciiImage.getWidth))
  }

  test("Get pixel by correct indexes") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    val rgbPixel: ASCIIPixel = new ASCIIPixel(100)
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    for (y <- 0 until 1 by 1) {
      for (x <- 0 until 2 by 1) {
        assert(rgbPixel.equals(asciiImage.getPixel(x, y)))
      }
    }
  }

  test("Get pixel by incorrect indexes") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)
    assertThrows[IllegalStateException](asciiImage.getPixel(1, 1))
  }
}
