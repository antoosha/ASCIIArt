package ui.parser

/**
 * Parse something.
 *
 * @tparam T list of arguments to parse.
 * @tparam R list of parsed arguments.
 */
trait Parser[T, R] {

  def parse(args: List[T]): List[R]

}
