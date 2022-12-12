package business.loaders.image

import models.images.RGBImage
import org.scalatest.FunSuite

class RandomImageLoaderTest extends FunSuite {

  val randomImageLoader: RandomImageLoader = new RandomImageLoader()

  test("Random image is correctly initialized, check height") {
    val loadedImage: RGBImage = randomImageLoader.load()
    assert(loadedImage.getHeight > 0)
  }

  test("Random image is correctly initialized, check width") {
    val loadedImage: RGBImage = randomImageLoader.load()
    assert(loadedImage.getWidth > 0)
  }
}
