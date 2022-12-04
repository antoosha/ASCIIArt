package business.exporters.image.file

import models.images.ASCIIImage

import java.io.{BufferedWriter, File, FileWriter}

class TxtFileASCIIImageExporter extends FileImageExporter[ASCIIImage] {

  override def export(item: ASCIIImage, path: Option[String]): Unit = {

    val file = new File(path.get)
    val bw = new BufferedWriter(new FileWriter(file))
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getHeight) {
        bw.write(item.getPixel(x, y).getBrightness)
      }
      bw.write("\n")
    }
    bw.close()
  }
}
