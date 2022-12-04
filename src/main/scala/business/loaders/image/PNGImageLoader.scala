package business.loaders.image

import models.grids.RGBGrid
import models.images.RGBImage
import models.pixels.RGBPixel

import java.awt.Color
import java.io.File
import javax.imageio.ImageIO
import scala.collection.mutable.ListBuffer

class PNGImageLoader extends ImageLoader[String, RGBImage] {

  override def load(path: String): RGBImage = {

    try {
      val image = ImageIO.read(new File(path))
      val pixelList = ListBuffer[ListBuffer[RGBPixel]]()

      for (y <- 0 until image.getHeight()) {
        val pixelRow = ListBuffer[RGBPixel]()
        for (x <- 0 until image.getWidth()) {
          val rgb = new Color(image.getRGB(x, y))
          pixelRow.append(new RGBPixel(rgb.getRed, rgb.getGreen, rgb.getBlue))
        }
        pixelList.append(pixelRow)
      }

      RGBImage(RGBGrid(pixelList))
    } catch {
      case e: Exception => throw new IllegalStateException(s"${e.getMessage} while importing image from $path.")
    }
  }
}
