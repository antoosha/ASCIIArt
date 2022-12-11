package business.filters.image.grayscale

import models.Axis
import models.grids.pixel.GrayscaleGrid
import models.images.GrayscaleImage
import models.pixels.GrayscalePixel
import org.scalatest.FunSuite

class FlipGrayscaleImageFilterTest extends FunSuite {

  test("Apply filter  flip by x axis for a 1x1 image. Height was not changed") {
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

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter  flip by x axis for a 1x1 image. Width was not changed") {
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

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter  flip by x axis for a 1x1 image. Check value") {
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

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter  flip by y axis for a 1x2 image. Height was not changed") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)
    pixelRow = pixelRow.appended(grayscalePixel2)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel2)
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.Y)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter  flip by y axis for a 1x2 image. Width was not changed") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)
    pixelRow = pixelRow.appended(grayscalePixel2)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel2)
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.Y)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter  flip by y axis for a 1x2 image. Check pixel (0;0)") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)
    pixelRow = pixelRow.appended(grayscalePixel2)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel2)
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.Y)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter  flip by y axis for a 1x2 image. Check pixel (1;0)") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)
    pixelRow = pixelRow.appended(grayscalePixel2)
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel2)
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.Y)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(1, 0).getBrightness.equals(filteredImage.getPixel(1, 0).getBrightness))
  }

  test("Apply filter  flip by x axis for a 2x1 image. Height was not changed") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)

    var pixelRow2: Seq[GrayscalePixel] = Seq.empty
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    pixelRow2 = pixelRow2.appended(grayscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    pixelGrid = pixelGrid.appended(pixelRow2)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)

    var resultPixelRow2: Seq[GrayscalePixel] = Seq.empty
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    resultPixelRow2 = resultPixelRow2.appended(resultGrayscalePixel2)

    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow2)
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter  flip by x axis for a 2x1 image. Width was not changed") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)

    var pixelRow2: Seq[GrayscalePixel] = Seq.empty
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    pixelRow2 = pixelRow2.appended(grayscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    pixelGrid = pixelGrid.appended(pixelRow2)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)

    var resultPixelRow2: Seq[GrayscalePixel] = Seq.empty
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    resultPixelRow2 = resultPixelRow2.appended(resultGrayscalePixel2)

    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow2)
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }

  test("Apply filter  flip by x axis for a 2x1 image. Check value (0;0)") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)

    var pixelRow2: Seq[GrayscalePixel] = Seq.empty
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    pixelRow2 = pixelRow2.appended(grayscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    pixelGrid = pixelGrid.appended(pixelRow2)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)

    var resultPixelRow2: Seq[GrayscalePixel] = Seq.empty
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    resultPixelRow2 = resultPixelRow2.appended(resultGrayscalePixel2)

    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow2)
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter  flip by x axis for a 2x1 image. Check value (0;1)") {
    //to filter image
    val grayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var pixelRow: Seq[GrayscalePixel] = Seq.empty
    pixelRow = pixelRow.appended(grayscalePixel1)

    var pixelRow2: Seq[GrayscalePixel] = Seq.empty
    val grayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    pixelRow2 = pixelRow2.appended(grayscalePixel2)

    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    pixelGrid = pixelGrid.appended(pixelRow2)
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    val resultGrayscalePixel1: GrayscalePixel = new GrayscalePixel(100)
    var resultPixelRow: Seq[GrayscalePixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultGrayscalePixel1)

    var resultPixelRow2: Seq[GrayscalePixel] = Seq.empty
    val resultGrayscalePixel2: GrayscalePixel = new GrayscalePixel(200)
    resultPixelRow2 = resultPixelRow2.appended(resultGrayscalePixel2)

    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow2)
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getPixel(0, 1).getBrightness.equals(filteredImage.getPixel(0, 1).getBrightness))
  }

  test("Apply filter  flip by x axis for a 0x0 image. Height was not changed") {
    //to filter image
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getHeight.equals(filteredImage.getHeight))
  }

  test("Apply filter  flip by x axis for a 0x0 image. Width was not changed") {
    //to filter image
    var pixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    val grayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(pixelGrid)
    val grayscaleImage: GrayscaleImage = GrayscaleImage(grayscalePixelGrid)

    ///result image
    var resultPixelGrid: Seq[Seq[GrayscalePixel]] = Seq.empty
    val resultGrayscalePixelGrid: GrayscaleGrid = GrayscaleGrid(resultPixelGrid)
    val resultGrayscaleImage: GrayscaleImage = GrayscaleImage(resultGrayscalePixelGrid)

    val filter: FlipGrayscaleImageFilter = new FlipGrayscaleImageFilter(Axis.X)
    val filteredImage: GrayscaleImage = filter.apply(grayscaleImage)
    assert(resultGrayscaleImage.getWidth.equals(filteredImage.getWidth))
  }
}
