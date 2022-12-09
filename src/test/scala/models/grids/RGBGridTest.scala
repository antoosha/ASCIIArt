package models.grids

import models.pixels.RGBPixel
import org.scalatest.FunSuite

class RGBGridTest extends FunSuite {

  test("Get height of the 0x0 grid") {
    val rgbPixelGrid: RGBGrid = RGBGrid(Seq.empty)
    assert(0.equals(rgbPixelGrid.getHeight))
  }

  test("Get width of the 0x0 grid") {
    val rgbPixelGrid: RGBGrid = RGBGrid(Seq.empty)
    assert(0.equals(rgbPixelGrid.getWidth))
  }

  test("Get height of the 1x2 grid") {
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    assert(1.equals(rgbPixelGrid.getHeight))
  }

  test("Get width of the 1x2 grid") {
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    assert(2.equals(rgbPixelGrid.getWidth))
  }

  test("Get element by correct indexes") {
    var pixelRow: Seq[RGBPixel] = Seq.empty
    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)

    for (y <- 0 until 1 by 1) {
      for (x <- 0 until 2 by 1) {
        assert(rgbPixel.equals(rgbPixelGrid.getElement(x, y)))
      }
    }
  }

  test("Get element by incorrect indexes") {
    val rgbPixelGrid: RGBGrid = RGBGrid(Seq.empty)
    assertThrows[IllegalStateException](rgbPixelGrid.getElement(1, 1))
  }
}
