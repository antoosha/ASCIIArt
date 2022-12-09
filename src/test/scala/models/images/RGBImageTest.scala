package models.images

import models.grids.RGBGrid
import models.pixels.RGBPixel
import org.scalatest.FunSuite

class RGBImageTest extends FunSuite {

  test("Get height of the 0x0 image") {
    val rgbPixelGrid: RGBGrid = RGBGrid(Seq.empty)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    assert(0.equals(rgbImage.getHeight))
  }

  test("Get width of the 0x0 image") {
    val rgbPixelGrid: RGBGrid = RGBGrid(Seq.empty)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    assert(0.equals(rgbImage.getWidth))
  }

  test("Get height of the 1x2 image") {
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    assert(1.equals(rgbImage.getHeight))
  }

  test("Get width of the 1x2 image") {
    var pixelRow: Seq[RGBPixel] = Seq.empty
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))
    pixelRow = pixelRow.appended(new RGBPixel(1, 1, 1))

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    assert(2.equals(rgbImage.getWidth))
  }

  test("Get pixel by correct indexes") {
    var pixelRow: Seq[RGBPixel] = Seq.empty
    val rgbPixel: RGBPixel = new RGBPixel(1, 1, 1)
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[RGBPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val rgbPixelGrid: RGBGrid = RGBGrid(pixelGrid)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)

    for (y <- 0 until 1 by 1) {
      for (x <- 0 until 2 by 1) {
        assert(rgbPixel.equals(rgbImage.getPixel(x, y)))
      }
    }
  }

  test("Get pixel by incorrect indexes") {
    val rgbPixelGrid: RGBGrid = RGBGrid(Seq.empty)
    val rgbImage: RGBImage = RGBImage(rgbPixelGrid)
    assertThrows[IllegalStateException](rgbImage.getPixel(1, 1))
  }
}
