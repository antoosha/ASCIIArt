package ui.parser

trait Parser[T, R] {

  def parse(args: T): R

}
