package models.grids

import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

class ASCIIGridTest extends FunSuite {

  test("Get height of the 0x0 grid") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    assert(0.equals(asciiPixelGrid.getHeight))
  }

  test("Get width of the 0x0 grid") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    assert(0.equals(asciiPixelGrid.getWidth))
  }

  test("Get height of the 1x2 grid") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(new ASCIIPixel(100))
    pixelRow = pixelRow.appended(new ASCIIPixel(100))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    assert(1.equals(asciiPixelGrid.getHeight))
  }

  test("Get width of the 1x2 grid") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(new ASCIIPixel(100))
    pixelRow = pixelRow.appended(new ASCIIPixel(100))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    assert(2.equals(asciiPixelGrid.getWidth))
  }

  test("Get element by correct indexes") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)

    for (y <- 0 until 1 by 1) {
      for (x <- 0 until 2 by 1) {
        assert(asciiPixel.equals(asciiPixelGrid.getElement(x, y)))
      }
    }
  }

  test("Get element by incorrect indexes") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    assertThrows[IllegalStateException](asciiPixelGrid.getElement(1, 1))
  }
}
