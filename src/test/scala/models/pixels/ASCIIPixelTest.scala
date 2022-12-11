package models.pixels

import org.scalatest.FunSuite

class ASCIIPixelTest extends FunSuite {

  test("Correctly initialized instance by default") {
    val asciiPixel: ASCIIPixel = ASCIIPixel()
    assert(' '.equals(asciiPixel.getPixel))
  }

  test("Correctly initialized instance by constructor") {
    assert('U'.equals(ASCIIPixel('U').getPixel))
  }
}
