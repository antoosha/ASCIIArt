package ui.parser

import models.Argument

/**
 * Represents parsing of console arguments
 */
class ConsoleParser extends Parser[Seq[String], Seq[Argument]] {

  private var arguments: Seq[Argument] = Seq()

  /**
   * Parses console arguments
   *
   * @param args to parse
   * @return parsed arguments
   */
  override def parse(args: Seq[String]): Seq[Argument] = {

    if (args.isEmpty) {
      throw new IllegalStateException("No arguments found.")
    }

    var i: Int = 0
    while (i < args.length) {
      args(i) match {
        case "--image" => {
          addArgument(args(i), i + 1, args)
          i += 1
        }
        case "--output-file" => {
          addArgument(args(i), i + 1, args)
          i += 1
        }
        case "--brightness" => {
          addArgument(args(i), i + 1, args)
          i += 1
        }
        case "--flip" => {
          addArgument(args(i), i + 1, args)
          i += 1
        }
        case "--table" => {
          addArgument(args(i), i + 1, args)
          i += 1
        }
        case "--custom-table" => {
          addArgument(args(i), i + 1, args)
          i += 1
        }
        case "--invert" => {
          addArgument(args(i))
        }
        case "--image-random" => {
          addArgument(args(i))
        }
        case "--output-console" => {
          addArgument(args(i))
        }
        case _ => throw new IllegalStateException("There is no known command as \"" + args(i) + "\". ")
      }
      i += 1
    }
    arguments
  }

  private def addArgument(text: String, idxVal: Int, args: Seq[String]): Unit = {
    if (idxVal > args.length) {
      throw new IllegalStateException("Parameter " + text + "has to have value.")
    }
    arguments = arguments.appended(new Argument(text, Some(args(idxVal))))
  }

  private def addArgument(text: String): Unit = {
    arguments = arguments.appended(new Argument(text, None))
  }
}
