package ui.parser

/**
 * Interface for parsing
 *
 * @tparam T arguments to parse
 * @tparam R parsed arguments
 */
trait Parser[T, R] {

  /**
   * Parses input arguments
   *
   * @param args to parse
   * @return parsed arguments
   */
  def parse(args: T): R

}
