package ui.parser

import models.Argument

class ConsoleParser extends Parser[String, Argument] {
  override def parse(args: List[String]): List[Argument] = {
    //TODO parse input to list of Arguments
    return List.empty
  }
}
