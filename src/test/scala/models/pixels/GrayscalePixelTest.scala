package models.pixels

import org.scalatest.FunSuite

class GrayscalePixelTest extends FunSuite {

  test("Correctly initialized instance by default") {
    val grayscalePixel: GrayscalePixel = new GrayscalePixel()
    assert(0.equals(grayscalePixel.getBrightness))
  }

  test("Correctly initialized instance by constructor") {
    val grayscalePixel: GrayscalePixel = new GrayscalePixel(100)
    assert(100.equals(grayscalePixel.getBrightness))
  }

  test("Incorrectly initialized instance, brightness < 0") {
    assertThrows[IllegalArgumentException](new GrayscalePixel(-1))
  }

  test("Incorrectly initialized instance, brightness > 255") {
    assertThrows[IllegalArgumentException](new GrayscalePixel(256))
  }
}
