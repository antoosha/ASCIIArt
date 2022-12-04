package ui.worker

import business.exporters.image.console.ConsoleASCIIImageExporter
import business.exporters.image.file.TxtFileASCIIImageExporter
import business.loaders.image.file.{JPGImageLoader, PNGImageLoader}
import business.loaders.image.RandomImageLoader
import models.Argument
import models.images.{ASCIIImage, Image}
import ui.parser.{ConsoleParser, Parser}
import ui.presenter.{ConsoleTextPresenter, Presenter}

import java.io.OutputStream
import scala.Console.out
import scala.collection.mutable.ListBuffer

class ConsoleWorker extends Worker {

  private val parser: Parser[List[String], ListBuffer[Argument]] = new ConsoleParser
  private val textPresenter: Presenter[OutputStream, String] = new ConsoleTextPresenter
  private val jpgImageLoader: JPGImageLoader = new JPGImageLoader()
  private val pngImageLoader: PNGImageLoader = new PNGImageLoader()
  private val randomImageLoader: RandomImageLoader = new RandomImageLoader()
  private val consoleASCIIImageExporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter
  private val txtFileASCIIImageExporter: TxtFileASCIIImageExporter = new TxtFileASCIIImageExporter
  private val welcomeText: String = "Welcome to ASCIIArt application!!!\n"


  override def work(args: List[String]): Unit = {

    textPresenter.present(out, welcomeText)
    resolveCommands(sortCommands(parser.parse(args)))
  }

  // todo move logic from cases to private methods
  private def resolveCommands(commands: ListBuffer[Argument]): Unit = {

    var loadedImage: Option[Image] = None
    var convertedImage: Option[ASCIIImage] = None

    // todo check if command --image is only one
    //commands.foreach(c => Console.println(c.getText + " " + c.getValue))

    for (command <- commands) {
      command.getText match {
        case "--image" => {
          if (command.getValue.get.contains(".jpg") || command.getValue.get.contains(".jpeg")) {
            loadedImage = Some(jpgImageLoader.load(command.getValue.get))
          }
          else if (command.getValue.get.contains(".png")) {
            loadedImage = Some(pngImageLoader.load(command.getValue.get))
          } else {
            throw new IllegalStateException(s"It is not possible to load file ${command.getText} because of it's format.")
          }
        }
        case "--output-file" => {
          if (command.getValue.get.contains(".txt")) {
            txtFileASCIIImageExporter.export(convertedImage.get, command.getValue)
          } else {
            throw new IllegalStateException(s"It is not possible to export to file ${command.getText} because of it's format. "
              + s"Only .txt format is possible.")
          }
        }
        case "--rotate" => {

        }
        case "--scale" => {

        }
        case "--invert" => {

        }
        case "--image-random" => {
          loadedImage = Some(randomImageLoader.load(None))
        }
        case "--output-console" => {
          consoleASCIIImageExporter.export(convertedImage.get, None)
        }
        case _ => throw new IllegalStateException(s"Something went wrong with ${command.getText} command.")
      }
    }
  }

  private def sortCommands(commands: ListBuffer[Argument]): ListBuffer[Argument] = {
    var editedCommands = commands
    val sorted: ListBuffer[Argument] = ListBuffer()

    //add import
    sorted.append(editedCommands.find(a => a.getText.equals("--image"))
      .getOrElse(throw new IllegalStateException("There is no command --image to import any image.")))
    editedCommands = editedCommands.dropWhile(a => a.getText.equals("--image"))

    //add all filters
    for (command <- editedCommands) {
      if (command.getText != "--output-console" && command.getText != "--output-file") {
        sorted.append(command)
        editedCommands = editedCommands.dropWhile(a => a.getText.equals(command.getText))
      }
    }

    //add exports
    for (command <- editedCommands) {
      sorted.append(command)
    }

    sorted
  }
}
