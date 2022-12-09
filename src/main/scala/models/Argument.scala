package models

class Argument {

  private var text: String = ""
  private var value: Option[String] = None

  def this(text: String, value: Option[String]) {
    this()
    if (text.isEmpty) {
      throw new IllegalArgumentException("Text parameter is required.")
    }
    this.text = text
    this.value = value
  }

  def getText: String = text

  def getValue: Option[String] = value
}

