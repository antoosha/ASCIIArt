package business.exporters.image.file

import models.images.ASCIIImage

import java.io.{BufferedWriter, File, FileWriter}

/**
 * Represents exporting image to .txt file
 *
 * @param pathToFile relative or absolute path to file to export
 */
class TxtFileASCIIImageExporter(pathToFile: String) extends FileImageExporter[ASCIIImage] {

  /**
   * Exports ASCIIImage to file
   *
   * @param item ASCII image to export
   */
  override def export(item: ASCIIImage): Unit = {

    val file = new File(pathToFile)
    val bw = new BufferedWriter(new FileWriter(file))
    for (y <- 0 until item.getHeight) {
      for (x <- 0 until item.getWidth) {
        bw.write(item.getPixel(x, y).getPixel)
      }
      bw.write("\n")
    }
    bw.close()
  }
}
