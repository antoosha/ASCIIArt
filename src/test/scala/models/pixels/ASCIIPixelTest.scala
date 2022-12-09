package models.pixels

import org.scalatest.FunSuite

class ASCIIPixelTest extends FunSuite {

  test("Correctly initialized instance") {
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    assert(100.equals(asciiPixel.getBrightness))
    assert(' ' == asciiPixel.getPixel)
  }

  test("Incorectly initialized instance") {
    assertThrows[IllegalArgumentException](new ASCIIPixel(-1))
    assertThrows[IllegalArgumentException](new ASCIIPixel(256))
  }

}
