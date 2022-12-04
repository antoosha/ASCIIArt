package ui.worker

import models.Argument
import models.images.Image
import ui.parser.{ConsoleParser, Parser}
import ui.presenter.{ConsoleImagePresenter, ConsoleTextPresenter, Presenter}

import java.io.OutputStream
import scala.Console.out
import scala.collection.mutable.ListBuffer

class ConsoleWorker extends Worker {

  val parser: Parser[List[String], ListBuffer[Argument]] = new ConsoleParser
  val textPresenter: Presenter[OutputStream, String] = new ConsoleTextPresenter
  val imagePresenter: Presenter[OutputStream, Image] = new ConsoleImagePresenter
  val welcomeText: String = "Welcome to ASCIIArt application!!!\n"

  override def work(args: List[String]): Unit = {

    textPresenter.present(out, welcomeText)
    resolveCommands(sortCommands(parser.parse(args)))
  }

  private def resolveCommands(commands: ListBuffer[Argument]): Unit = {

    for (command <- commands) {
      command.text match {
        case "--image" => {

        }
        case "--output-file" => {

        }
        case "--rotate" => {

        }
        case "--scale" => {

        }
        case "--invert" => {

        }
        case "--output-console" => {

        }
        case _ => throw new IllegalStateException(s"Something went wrong with ${command.text} command.")
      }
    }
  }

  private def sortCommands(commands: ListBuffer[Argument]): ListBuffer[Argument] = {
    var editedCommands = commands
    val sorted: ListBuffer[Argument] = ListBuffer()

    //add import
    sorted.append(editedCommands.find(a => a.text.equals("--image"))
      .getOrElse(throw new IllegalStateException("There is no command --image to import any image.")))
    editedCommands = editedCommands.dropWhile(a => a.text.equals("--image"))

    //add all filters
    for (command <- editedCommands) {
      if (command.text != "--output-console" && command.text != "--output-file") {
        sorted.append(command)
        editedCommands = editedCommands.dropWhile(a => a.text.equals(command.text))
      }
    }

    //add exports
    for (command <- editedCommands) {
      sorted.append(command)
    }

    sorted
  }
}
