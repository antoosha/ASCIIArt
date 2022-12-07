package ui.worker

import business.converters.image.RGBToASCIIImageConverter
import business.exporters.image.console.ConsoleASCIIImageExporter
import business.exporters.image.file.TxtFileASCIIImageExporter
import business.filters.image.{InvertImageFilter, RotateImageFilter, ScaleImageFilter}
import business.loaders.image.RandomImageLoader
import business.loaders.image.file.{JPGImageLoader, PNGImageLoader}
import models.Argument
import models.images.RGBImage
import models.tables.linear.UserLinearConversionTable
import models.tables.nonlinear.SimpleNonLinearConversionTable
import ui.parser.{ConsoleParser, Parser}

import scala.collection.mutable.ListBuffer

class ConsoleWorker extends Worker {

  private val parser: Parser[List[String], ListBuffer[Argument]] = new ConsoleParser
  private val jpgImageLoader: JPGImageLoader = new JPGImageLoader()
  private val pngImageLoader: PNGImageLoader = new PNGImageLoader()
  private val randomImageLoader: RandomImageLoader = new RandomImageLoader()
  private val consoleASCIIImageExporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter
  private val txtFileASCIIImageExporter: TxtFileASCIIImageExporter = new TxtFileASCIIImageExporter
  private val converter: RGBToASCIIImageConverter = RGBToASCIIImageConverter()


  // maybe rewrite to Commands and each user's input is one of those commands
  override def work(args: List[String]): Unit = {

    resolveCommands(sortCommands(parser.parse(args)))
  }

  private def resolveCommands(commands: ListBuffer[Argument]): Unit = {

    var loadedImage: Option[RGBImage] = None

    // todo check if command --image is only one
    //commands.foreach(c => Console.println(c.getText + " " + c.getValue))

    for (command <- commands) {
      command.getText match {
        case "--image" => {
          if (command.getValue.get.endsWith(".jpg") || command.getValue.get.endsWith(".jpeg")) {
            loadedImage = Some(jpgImageLoader.load(command.getValue.get))
          }
          else if (command.getValue.get.contains(".png")) {
            loadedImage = Some(pngImageLoader.load(command.getValue.get))
          } else {
            throw new IllegalStateException(s"It is not possible to load file ${command.getText} because of it's format.")
          }
        }
        case "--output-file" => {
          if (command.getValue.get.endsWith(".txt")) {
            txtFileASCIIImageExporter.export(converter.convert(loadedImage.get), command.getValue.get)
          } else {
            throw new IllegalStateException(s"It is not possible to export to file ${command.getText} because of it's format. "
              + s"Only .txt format is possible.")
          }
        }
        case "--rotate" => {
          val rotateFilter: RotateImageFilter = new RotateImageFilter(command.getValue.get)
          converter.addFilter(rotateFilter)
        }
        case "--scale" => {
          val scaleFilter: ScaleImageFilter = new ScaleImageFilter(command.getValue.get)
          converter.addFilter(scaleFilter)
        }
        case "--invert" => {
          val invertFilter: InvertImageFilter = new InvertImageFilter(command.getValue.get)
          converter.addFilter(invertFilter)
        }
        case "--table" => {
          command.getValue.get match {
            case "linearBrokes" => //is set by default
            case "nonLinearSimple" => converter.setTable(SimpleNonLinearConversionTable())
            case _ => throw new IllegalStateException(s"Table name ${command.getValue.get} does not exist.")
          }
        }
        case "--custom-table" => {
          converter.setTable(UserLinearConversionTable(command.getValue.get))
        }
        case "--image-random" => {
          loadedImage = Some(randomImageLoader.load(None))
        }
        case "--output-console" => {
          consoleASCIIImageExporter.export(converter.convert(loadedImage.get), Console.out)
        }
        case _ => throw new IllegalStateException(s"Something went wrong with ${command.getText} command.")
      }
    }
  }

  private def sortCommands(commands: ListBuffer[Argument]): ListBuffer[Argument] = {

    var editedCommands = commands
    val sorted: ListBuffer[Argument] = ListBuffer()

    //add imports
    // todo check if import is only one
    sorted.append(editedCommands.find(a => a.getText.equals("--image"))
      .getOrElse(throw new IllegalStateException("There is no command --image to import any image.")))
    editedCommands = editedCommands.dropWhile(a => a.getText.equals("--image"))

    //add table and filters
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
