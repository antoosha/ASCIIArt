package business.loaders.image

import models.images.RGBImage

class RandomImageLoader extends ImageLoader[String, RGBImage] {

  override def load(path: String): RGBImage = {

    // todo write logic
    RGBImage()
  }
}
