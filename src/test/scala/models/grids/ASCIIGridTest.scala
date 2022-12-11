package models.grids

import models.grids.pixel.ASCIIGrid
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
    pixelRow = pixelRow.appended(ASCIIPixel('U'))
    pixelRow = pixelRow.appended(ASCIIPixel('U'))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    assert(1.equals(asciiPixelGrid.getHeight))
  }

  test("Get width of the 1x2 grid") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(ASCIIPixel('U'))
    pixelRow = pixelRow.appended(ASCIIPixel('U'))

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    assert(2.equals(asciiPixelGrid.getWidth))
  }

  test("Get element by correct indexes x=0, y=0") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    val asciiPixel: ASCIIPixel = ASCIIPixel('U')
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)

    assert(asciiPixel.equals(asciiPixelGrid.getElement(0, 0)))
  }

  test("Get element by correct indexes x=1, y=0") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    val asciiPixel: ASCIIPixel = ASCIIPixel('U')
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)

    assert(asciiPixel.equals(asciiPixelGrid.getElement(1, 0)))
  }


  test("Get element by incorrect indexes") {
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(Seq.empty)
    assertThrows[IllegalStateException](asciiPixelGrid.getElement(1, 1))
  }
}
