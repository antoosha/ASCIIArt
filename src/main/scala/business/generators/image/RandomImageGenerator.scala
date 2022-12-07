package business.generators.image

import models.grids.RGBGrid
import models.images.RGBImage
import models.pixels.RGBPixel

import scala.collection.mutable.ListBuffer

class RandomImageGenerator() extends ImageGenerator {
  override def generate(): RGBImage = {
    val from: Int = 200
    val to: Int = 1600

    val rg = scala.util.Random
    val width = rg.between(from, to)
    val height = rg.between(from, to)
    var generatedPixelGrid = ListBuffer[ListBuffer[RGBPixel]]()
    for (i <- 0 until height) {
      val pixelRow = ListBuffer[RGBPixel]()
      for (j <- 0 until width) {
        pixelRow.append(new RGBPixel(rg.nextInt(256), rg.nextInt(256), rg.nextInt(256)))
      }
      generatedPixelGrid.append(pixelRow)
    }

    RGBImage(RGBGrid(generatedPixelGrid))
  }
}
