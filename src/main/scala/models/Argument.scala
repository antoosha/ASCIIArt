package models

case class Argument(private val text: String, private val value: Option[String]) {
  def getText: String = text

  def getValue: Option[String] = value
}

