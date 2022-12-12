package business.loaders.image

import business.generators.image.RandomImageGenerator
import models.images.RGBImage

/**
 * Represents random image loader
 */
class RandomImageLoader extends ImageLoader[RGBImage] {

  private val randomImageGenerator: RandomImageGenerator = new RandomImageGenerator()

  /**
   * Loads random image using random image generator
   *
   * @return loaded item
   */
  override def load(): RGBImage = {
    randomImageGenerator.generate()
  }
}
