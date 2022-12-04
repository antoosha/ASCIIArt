package ui.parser

import models.Argument
import ui.exceptions.InputConsoleParserException

class ConsoleParser extends Parser[List[String], List[Argument]] {

  private val arguments: List[Argument] = List()

  override def parse(args: List[String]): List[Argument] = {

    if (args.isEmpty) {
      throw new InputConsoleParserException("No arguments found.")
    }

    val arguments: List[Argument] = List()
    for (i <- 0 to args.length if i % 2 == 0) {
      args.take(i).last match {
        case "--image" => {
          addArgument(args.take(i).last, i + 1, args)
        }
        case "--output-file" => {
          addArgument(args.take(i).last, i + 1, args)
        }
        case "--rotate" => {
          addArgument(args.take(i).last, i + 1, args)
        }
        case "--invert" => {
          addArgument(args.take(i).last, i + 1, args)
        }
        case "--scale" => {
          addArgument(args.take(i).last, i + 1, args)
        }
        case _ => throw new InputConsoleParserException("There is noo known command as \"" + args.take(i).last + "\". ")
      }
    }
    arguments
  }

  private def addArgument(text: String, idxVal: Int, args: List[String]): Unit = {
    if (idxVal > args.length) {
      throw new InputConsoleParserException("Parameter " + text + "has to have value.")
    }
    arguments.appended(Argument(text, args.take(idxVal).last))
  }
}
