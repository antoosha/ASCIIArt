package models

import org.scalatest.FunSuite

class ArgumentTest extends FunSuite {

  test("Correctly initialized instance, checking 'text'") {
    val argument: Argument = new Argument("--image", Some("images/image1.png"))
    assert("--image".equals(argument.getText))
  }
  test("Correctly initialized instance, checking 'value'") {
    val argument: Argument = new Argument("--image", Some("images/image1.png"))
    assert("images/image1.png".equals(argument.getValue.get))
  }

  test("Incorrectly initialized instance") {
    assertThrows[IllegalArgumentException](new Argument("", None))
  }
}
