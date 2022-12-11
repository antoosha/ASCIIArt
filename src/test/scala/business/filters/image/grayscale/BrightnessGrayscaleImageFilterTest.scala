package business.filters.image.grayscale

import models.grids.pixel.GrayscaleGrid
import models.images.GrayscaleImage
import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class BrightnessGrayscaleImageFilterTest extends FunSuite {

  test("Apply filter +100 brightness. Height was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("+100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter +100 brightness. Width was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("+100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter +100 brightness. Check brightness value") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("+100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter 100 brightness. Height was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter 100 brightness. Width was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter 100 brightness. Check brightness value") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter -100 brightness. Height was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(0)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("-100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter -100 brightness. Width was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(0)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("-100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter -100 brightness. Check brightness value") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(0)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("-100")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter 0 brightness. Height was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("0")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter 0 brightness. Width was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("0")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter 0 brightness. Check brightness value") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("0")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter 300 brightness. Height was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(255)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("300")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter 300 brightness. Width was not changed") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(255)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("300")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter 300 brightness. Check brightness value") {
    //to filter image
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel: GrayscalePixel = new GrayscalePixel(255)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter("300")
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }
}
