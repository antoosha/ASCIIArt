package business.filters.image.ascii

import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

class BrightnessASCIIImageFilterTest extends FunSuite {

  test("Apply filter +100 brightness") {
    //to filter image
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    ///result image
    val resultAsciiPixel: ASCIIPixel = new ASCIIPixel(200)
    var resultPixelRow: Seq[ASCIIPixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultAsciiPixel)
    var resultPixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultAsciiPixelGrid: ASCIIGrid = ASCIIGrid(resultPixelGrid)
    val resultAsciiImage: ASCIIImage = ASCIIImage(resultAsciiPixelGrid)

    val filter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter("+100")
    val filteredImage: ASCIIImage = filter.apply(asciiImage)
    assert(resultAsciiImage.getHeight.equals(filteredImage.getHeight))
    assert(resultAsciiImage.getWidth.equals(filteredImage.getWidth))
    assert(resultAsciiImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter 100 brightness") {
    //to filter image
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    ///result image
    val resultAsciiPixel: ASCIIPixel = new ASCIIPixel(200)
    var resultPixelRow: Seq[ASCIIPixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultAsciiPixel)
    var resultPixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultAsciiPixelGrid: ASCIIGrid = ASCIIGrid(resultPixelGrid)
    val resultAsciiImage: ASCIIImage = ASCIIImage(resultAsciiPixelGrid)

    val filter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter("100")
    val filteredImage: ASCIIImage = filter.apply(asciiImage)
    assert(resultAsciiImage.getHeight.equals(filteredImage.getHeight))
    assert(resultAsciiImage.getWidth.equals(filteredImage.getWidth))
    assert(resultAsciiImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter -100 brightness") {
    //to filter image
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    ///result image
    val resultAsciiPixel: ASCIIPixel = new ASCIIPixel(0)
    var resultPixelRow: Seq[ASCIIPixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultAsciiPixel)
    var resultPixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultAsciiPixelGrid: ASCIIGrid = ASCIIGrid(resultPixelGrid)
    val resultAsciiImage: ASCIIImage = ASCIIImage(resultAsciiPixelGrid)

    val filter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter("-100")
    val filteredImage: ASCIIImage = filter.apply(asciiImage)
    assert(resultAsciiImage.getHeight.equals(filteredImage.getHeight))
    assert(resultAsciiImage.getWidth.equals(filteredImage.getWidth))
    assert(resultAsciiImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter 0 brightness") {
    //to filter image
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    ///result image
    val resultAsciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var resultPixelRow: Seq[ASCIIPixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultAsciiPixel)
    var resultPixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultAsciiPixelGrid: ASCIIGrid = ASCIIGrid(resultPixelGrid)
    val resultAsciiImage: ASCIIImage = ASCIIImage(resultAsciiPixelGrid)

    val filter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter("0")
    val filteredImage: ASCIIImage = filter.apply(asciiImage)
    assert(resultAsciiImage.getHeight.equals(filteredImage.getHeight))
    assert(resultAsciiImage.getWidth.equals(filteredImage.getWidth))
    assert(resultAsciiImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter 300 brightness") {
    //to filter image
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    ///result image
    val resultAsciiPixel: ASCIIPixel = new ASCIIPixel(255)
    var resultPixelRow: Seq[ASCIIPixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultAsciiPixel)
    var resultPixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultAsciiPixelGrid: ASCIIGrid = ASCIIGrid(resultPixelGrid)
    val resultAsciiImage: ASCIIImage = ASCIIImage(resultAsciiPixelGrid)

    val filter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter("300")
    val filteredImage: ASCIIImage = filter.apply(asciiImage)
    assert(resultAsciiImage.getHeight.equals(filteredImage.getHeight))
    assert(resultAsciiImage.getWidth.equals(filteredImage.getWidth))
    assert(resultAsciiImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }

  test("Apply filter -300 brightness") {
    //to filter image
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    ///result image
    val resultAsciiPixel: ASCIIPixel = new ASCIIPixel(0)
    var resultPixelRow: Seq[ASCIIPixel] = Seq.empty
    resultPixelRow = resultPixelRow.appended(resultAsciiPixel)
    var resultPixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    resultPixelGrid = resultPixelGrid.appended(resultPixelRow)
    val resultAsciiPixelGrid: ASCIIGrid = ASCIIGrid(resultPixelGrid)
    val resultAsciiImage: ASCIIImage = ASCIIImage(resultAsciiPixelGrid)

    val filter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter("-300")
    val filteredImage: ASCIIImage = filter.apply(asciiImage)
    assert(resultAsciiImage.getHeight.equals(filteredImage.getHeight))
    assert(resultAsciiImage.getWidth.equals(filteredImage.getWidth))
    assert(resultAsciiImage.getPixel(0, 0).getBrightness.equals(filteredImage.getPixel(0, 0).getBrightness))
  }
}
