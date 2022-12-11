package business.exporters.image.console

import business.exporters.image.ImageExporter
import models.images.ASCIIImage

import java.io.PrintStream

class ConsoleASCIIImageExporter(os: PrintStream) extends ImageExporter[ASCIIImage] {

  override def export(item: ASCIIImage): Unit = {
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getWidth) {
        os.print(item.getPixel(x, y).getPixel)
      }
      os.println()
    }
  }
}
