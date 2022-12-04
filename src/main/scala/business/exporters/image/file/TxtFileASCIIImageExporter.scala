package business.exporters.image.file

import models.images.ASCIIImage

import java.io.{BufferedWriter, File, FileWriter}

class TxtFileASCIIImageExporter extends FileImageExporter[ASCIIImage] {

  override def export(item: ASCIIImage, out: String): Unit = {

    val file = new File(out)
    val bw = new BufferedWriter(new FileWriter(file))
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getHeight) {
        bw.write(item.getPixel(x, y).getPixel)
      }
      bw.write("\n")
    }
    bw.close()
  }
}
