package business.generators.image

import models.grids.pixel.RGBGrid
import models.images.RGBImage
import models.pixels.RGBPixel

class RandomImageGenerator() extends ImageGenerator {

  override def generate(): RGBImage = {
    val from: Int = 200
    val to: Int = 1600

    val rg = scala.util.Random
    val width = rg.between(from, to)
    val height = rg.between(from, to)
    var generatedPixelGrid = Seq[Seq[RGBPixel]]()
    for (i <- 0 until height) {
      var pixelRow = Seq[RGBPixel]()
      for (j <- 0 until width) {
        pixelRow = pixelRow.appended(new RGBPixel(rg.nextInt(256), rg.nextInt(256), rg.nextInt(256)))
      }
      generatedPixelGrid = generatedPixelGrid.appended(pixelRow)
    }

    RGBImage(RGBGrid(generatedPixelGrid))
  }
}
