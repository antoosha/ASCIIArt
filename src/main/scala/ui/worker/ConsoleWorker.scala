package ui.worker

import models.Argument
import models.images.Image
import ui.parser.{ConsoleParser, Parser}
import ui.presenter.{ConsoleImagePresenter, ConsoleTextPresenter, Presenter}

import java.io.OutputStream
import scala.Console.out

class ConsoleWorker extends Worker {

  val parser: Parser[String, Argument] = new ConsoleParser
  val textPresenter: Presenter[OutputStream, String] = new ConsoleTextPresenter
  val imagePresenter: Presenter[OutputStream, Image] = new ConsoleImagePresenter
  val welcomeText: String = "Welcome to ASCIIArt application!!!"

  override def work(args: List[String]): Unit = {

    textPresenter.present(out, welcomeText)
    resolveCommands(parser.parse(args))
  }

  private def resolveCommands(commands: List[Argument]): Unit = {
    // firstly main commands
    // then filters
  }
}
