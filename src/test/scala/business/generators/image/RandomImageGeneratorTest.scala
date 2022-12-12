package business.generators.image

import models.images.RGBImage
import org.scalatest.FunSuite

class RandomImageGeneratorTest extends FunSuite {

  val generator: RandomImageGenerator = new RandomImageGenerator()

  test("Check correct initialized image, checking height is more or equals than 200") {
    val rgbImage: RGBImage = generator.generate()
    assert(rgbImage.getHeight >= 200)
  }

  test("Check correct initialized image, checking height is less equals than 800") {
    val rgbImage: RGBImage = generator.generate()
    assert(rgbImage.getHeight <= 800)
  }

  test("Check correct initialized image, checking width is more or equals than 200") {
    val rgbImage: RGBImage = generator.generate()
    assert(rgbImage.getWidth >= 200)
  }

  test("Check correct initialized image, checking width is less equals than 800") {
    val rgbImage: RGBImage = generator.generate()
    assert(rgbImage.getWidth <= 800)
  }
}
