package models.pixels

import org.scalatest.FunSuite

class RGBPixelTest extends FunSuite {

  test("Correctly initialized instance. Get red") {
    val rgbPixel: RGBPixel = new RGBPixel(0, 20, 255)
    assert(0.equals(rgbPixel.getRed))
  }

  test("Correctly initialized instance. get green") {
    val rgbPixel: RGBPixel = new RGBPixel(0, 20, 255)
    assert(20.equals(rgbPixel.getGreen))
  }

  test("Correctly initialized instance. Get blue") {
    val rgbPixel: RGBPixel = new RGBPixel(0, 20, 255)
    assert(255.equals(rgbPixel.getBlue))
  }

  test("Incorectly initialized instance, red is < 0") {
    assertThrows[IllegalStateException](new RGBPixel(-1, 20, 30))
  }

  test("Incorectly initialized instance, green is < 0 ") {
    assertThrows[IllegalStateException](new RGBPixel(10, -1, 30))
  }

  test("Incorectly initialized instance, blue is < 0 ") {
    assertThrows[IllegalStateException](new RGBPixel(-1, 20, -1))
  }

  test("Incorectly initialized instance, red is > 255 ") {
    assertThrows[IllegalStateException](new RGBPixel(256, 20, 30))
  }

  test("Incorectly initialized instance, green is > 255 ") {
    assertThrows[IllegalStateException](new RGBPixel(10, 256, 30))
  }

  test("Incorectly initialized instance, blue is > 255 ") {
    assertThrows[IllegalStateException](new RGBPixel(-1, 20, 256))
  }
}
