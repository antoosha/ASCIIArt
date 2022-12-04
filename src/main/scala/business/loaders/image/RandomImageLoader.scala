package business.loaders.image

import models.grids.RGBGrid
import models.images.RGBImage

import scala.collection.mutable.ListBuffer

class RandomImageLoader extends ImageLoader[String, RGBImage] {

  override def load(path: String): RGBImage = {

    // todo write logic
    RGBImage(RGBGrid(ListBuffer(ListBuffer())))
  }
}
