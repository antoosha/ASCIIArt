package business.loaders.image

import models.images.RGBImage

class PNGImageLoader extends ImageLoader[String, RGBImage] {

  override def load(path: String): RGBImage = {

    // todo write logic
    RGBImage()
  }
}
