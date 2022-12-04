package business.exporters.image.console

import business.exporters.image.ImageExporter
import models.images.ASCIIImage

import java.io.PrintStream

class ConsoleASCIIImageExporter extends ImageExporter[ASCIIImage, PrintStream] {

  override def export(item: ASCIIImage, out: PrintStream): Unit = {
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getHeight) {
        out.print(item.getPixel(x, y).getPixel)
      }
      out.println()
    }
  }
}
