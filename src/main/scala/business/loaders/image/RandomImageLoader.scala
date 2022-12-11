package business.loaders.image

import business.generators.image.RandomImageGenerator
import models.images.RGBImage

class RandomImageLoader extends ImageLoader[RGBImage] {

  private val randomImageGenerator: RandomImageGenerator = new RandomImageGenerator()

  override def load(): RGBImage = {
    randomImageGenerator.generate()
  }
}
