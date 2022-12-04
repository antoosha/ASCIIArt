package business.exporters.image.console

import business.exporters.image.ImageExporter
import models.images.ASCIIImage

class ConsoleASCIIImageExporter extends ImageExporter[ASCIIImage, String] {

  override def export(item: ASCIIImage, path: Option[String]): Unit = {
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getHeight) {
        Console.print(item.getPixel(x, y).getBrightness)
      }
      Console.println()
    }
  }
}
