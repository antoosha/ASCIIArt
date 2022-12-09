package models.pixels

import org.scalatest.FunSuite

class RGBPixelTest extends FunSuite {

  test("Correctly initialized instance") {
    val rgbPixel: RGBPixel = new RGBPixel(0, 20, 255)
    assert(0.equals(rgbPixel.getRed))
    assert(20.equals(rgbPixel.getGreen))
    assert(255.equals(rgbPixel.getBlue))
  }

  test("Incorectly initialized instance ") {
    assertThrows[IllegalStateException](new RGBPixel(-1, 20, 30))
    assertThrows[IllegalStateException](new RGBPixel(10, -1, 30))
    assertThrows[IllegalStateException](new RGBPixel(-1, 20, -1))

    assertThrows[IllegalStateException](new RGBPixel(256, 20, 30))
    assertThrows[IllegalStateException](new RGBPixel(10, 256, 30))
    assertThrows[IllegalStateException](new RGBPixel(-1, 20, 256))
  }
}
