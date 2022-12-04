package business.generators.image

import models.grids.RGBGrid
import models.images.RGBImage
import models.pixels.RGBPixel

import scala.collection.mutable.ListBuffer

class RandomImageGenerator() extends ImageGenerator {
  override def generate(): RGBImage = {
    val rg = scala.util.Random
    val width = rg.between(200, 1600)
    val height = rg.between(200, 1600)
    var generatedPixelGrid = ListBuffer[ListBuffer[RGBPixel]]()
    for (i <- 0 to height) {
      var pixelRow = ListBuffer[RGBPixel]()
      for (e <- 0 to width) {
        pixelRow.append(new RGBPixel(rg.nextInt(255), rg.nextInt(255), rg.nextInt(255)))
      }
      generatedPixelGrid.append(pixelRow)
    }

    RGBImage(RGBGrid(ListBuffer(ListBuffer())))
  }
}
