package models

import org.scalatest.FunSuite

class ArgumentTest extends FunSuite {

  test("Correctly initialized instance") {
    val argument: Argument = new Argument("--image", Some("images/image1.png"))
    assert("--image".equals(argument.getText))
    assert("images/image1.png".equals(argument.getValue.get))
  }

  test("Incorrectly initialized instance") {
    assertThrows[IllegalArgumentException](new Argument("", None))
  }
}
