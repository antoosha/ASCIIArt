package models.images

import models.grids.pixel.GrayscaleGrid
import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class GrayscaleImageTest extends FunSuite {


  test("Get height of the 0x0 image") {
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(Seq.empty)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)
    assert(0.equals(asciiImage.getHeight))
  }

  test("Get width of the 0x0 image") {
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(Seq.empty)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)
    assert(0.equals(asciiImage.getWidth))
  }

  test("Get height of the 1x2 image") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(new GrayscalePixel(100))
    pixelRow = pixelRow.appended(new GrayscalePixel(100))

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)
    assert(1.equals(asciiImage.getHeight))
  }

  test("Get width of the 1x2 image") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(new GrayscalePixel(100))
    pixelRow = pixelRow.appended(new GrayscalePixel(100))

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)
    assert(2.equals(asciiImage.getWidth))
  }

  test("Get pixel by correct indexes x=0, y=0") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    val rgbPixel: GrayscalePixel = new GrayscalePixel(100)
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    assert(rgbPixel.equals(asciiImage.getPixel(0, 0)))
  }

  test("Get pixel by correct indexes x=1, y=0") {
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    val rgbPixel: GrayscalePixel = new GrayscalePixel(100)
    pixelRow = pixelRow.appended(rgbPixel)
    pixelRow = pixelRow.appended(rgbPixel)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    assert(rgbPixel.equals(asciiImage.getPixel(1, 0)))
  }

  test("Get pixel by incorrect indexes") {
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(Seq.empty)
    val asciiImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)
    assertThrows[IllegalStateException](asciiImage.getPixel(1, 1))
  }
}
