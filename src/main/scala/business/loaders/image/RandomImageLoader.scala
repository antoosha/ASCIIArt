package business.loaders.image

import business.generators.image.RandomImageGenerator
import models.images.RGBImage

class RandomImageLoader extends ImageLoader[Option[String], RGBImage] {

  private val randomImageGenerator: RandomImageGenerator = new RandomImageGenerator()

  override def load(path: Option[String]): RGBImage = {
    randomImageGenerator.generate()
  }
}
