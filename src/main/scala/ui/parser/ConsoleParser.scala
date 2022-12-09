package ui.parser

import models.Argument

import scala.collection.mutable.ListBuffer

class ConsoleParser extends Parser[List[String], ListBuffer[Argument]] {

  private val arguments: ListBuffer[Argument] = ListBuffer()

  override def parse(args: List[String]): ListBuffer[Argument] = {

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
        case "--invert" => {
          addArgument(args(i))
        }
        case "--image-random" => {
          addArgument(args(i))
        }
        case "--output-console" => {
          addArgument(args(i))
        }
        case _ => throw new IllegalStateException("There is noo known command as \"" + args(i) + "\". ")
      }
      i += 1
    }
    arguments
  }

  private def addArgument(text: String, idxVal: Int, args: List[String]): Unit = {
    if (idxVal > args.length) {
      throw new IllegalStateException("Parameter " + text + "has to have value.")
    }
    arguments.append(Argument(text, Some(args(idxVal))))

  }

  private def addArgument(text: String): Unit = {
    arguments.append(Argument(text, None))
  }
}
