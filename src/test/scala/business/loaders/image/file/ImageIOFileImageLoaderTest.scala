package business.loaders.image.file

import org.scalatest.FunSuite

class ImageIOFileImageLoaderTest extends FunSuite {

  test("Correctly loaded png image, checking height") {
    val loader = new ImageIOFileImageLoader("src/test/resources/test.png")
    val rgbImage = loader.load()
    assert(200.equals(rgbImage.getHeight))
  }

  test("Correctly loaded png image, checking width") {
    val loader = new ImageIOFileImageLoader("src/test/resources/test.png")
    val rgbImage = loader.load()
    assert(200.equals(rgbImage.getWidth))
  }

  test("Correctly loaded jpg image, checking height") {
    val loader = new ImageIOFileImageLoader("src/test/resources/test2.jpg")
    val rgbImage = loader.load()
    assert(375.equals(rgbImage.getHeight))
  }

  test("Correctly loaded jpg image, checking width") {
    val loader = new ImageIOFileImageLoader("src/test/resources/test2.jpg")
    val rgbImage = loader.load()
    assert(450.equals(rgbImage.getWidth))
  }

  test("Exception when loading from non existent source") {
    assertThrows[IllegalStateException](new ImageIOFileImageLoader("src/test/resources/nonExistingSource.png").load())
  }
}
