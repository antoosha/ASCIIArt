package models.grids

import models.grids.pixel.GrayscaleGrid
import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class GrayscaleGridTest extends FunSuite {

  test("Get height of the 0x0 grid") {
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(Seq.empty)
    assert(0.equals(grayscalePixelGrid.getHeight))
  }

  test("Get width of the 0x0 grid") {
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(Seq.empty)
    assert(0.equals(grayscalePixelGrid.getWidth))
  }

  test("Get height of the 1x2 grid") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(new GrayscalePixel(100))
    pixelRow = pixelRow.appended(new GrayscalePixel(100))

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    assert(1.equals(grayscalePixelGrid.getHeight))
  }

  test("Get width of the 1x2 grid") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(new GrayscalePixel(100))
    pixelRow = pixelRow.appended(new GrayscalePixel(100))

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    assert(2.equals(grayscalePixelGrid.getWidth))
  }

  test("Get element by correct indexes x=0, y=0") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    val asciiPixel: GrayscalePixel = new GrayscalePixel(100)
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)

    assert(asciiPixel.equals(grayscalePixelGrid.getElement(0, 0)))
  }

  test("Get element by correct indexes x=1, y=0") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    val asciiPixel: GrayscalePixel = new GrayscalePixel(100)
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)

    assert(asciiPixel.equals(grayscalePixelGrid.getElement(1, 0)))
  }


  test("Get element by incorrect indexes") {
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(Seq.empty)
    assertThrows[IllegalStateException](grayscalePixelGrid.getElement(1, 1))
  }
}
