package business.loaders.image.file

import models.grids.RGBGrid
import models.images.RGBImage
import models.pixels.RGBPixel

import java.awt.Color
import java.io.File
import javax.imageio.ImageIO

class JpgPngImageLoader extends FileImageLoader[String, RGBImage] {

  override def load(path: String): RGBImage = {

    try {
      val image = ImageIO.read(new File(path))
      var pixelGrid = Seq[Seq[RGBPixel]]()

      for (y <- 0 until image.getHeight()) {
        var pixelRow = Seq[RGBPixel]()
        for (x <- 0 until image.getWidth()) {
          val rgb = new Color(image.getRGB(x, y))
          pixelRow = pixelRow.appended(new RGBPixel(rgb.getRed, rgb.getGreen, rgb.getBlue))
        }
        pixelGrid = pixelGrid.appended(pixelRow)
      }

      RGBImage(RGBGrid(pixelGrid))
    } catch {
      case e: Exception => throw new IllegalStateException(s"${e.getMessage} while importing image from $path.")
    }
  }
}
