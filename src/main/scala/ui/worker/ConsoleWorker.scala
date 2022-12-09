package ui.worker

import business.converters.image.RGBToASCIIImageConverter
import business.exporters.image.console.ConsoleASCIIImageExporter
import business.exporters.image.file.TxtFileASCIIImageExporter
import business.filters.image.ascii.{BrightnessASCIIImageFilter, FlipASCIIImageFilter, InvertASCIIImageFilter}
import business.loaders.image.RandomImageLoader
import business.loaders.image.file.JpgPngImageLoader
import models.Argument
import models.images.{ASCIIImage, RGBImage}
import models.tables.linear.UserLinearConversionTable
import models.tables.nonlinear.SimpleNonLinearConversionTable
import ui.parser.{ConsoleParser, Parser}

class ConsoleWorker extends Worker {

  private val parser: Parser[Seq[String], Seq[Argument]] = new ConsoleParser
  private val imageLoader: JpgPngImageLoader = new JpgPngImageLoader()
  private val randomImageLoader: RandomImageLoader = new RandomImageLoader()
  private val consoleASCIIImageExporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter
  private val txtFileASCIIImageExporter: TxtFileASCIIImageExporter = new TxtFileASCIIImageExporter
  private val converter: RGBToASCIIImageConverter = RGBToASCIIImageConverter()

  override def work(args: Seq[String]): Unit = {

    resolveCommands(sortCommands(parser.parse(args)))
  }

  private def resolveCommands(commands: Seq[Argument]): Unit = {

    var loadedImage: Option[RGBImage] = None
    var convertedImage: Option[ASCIIImage] = None

    for (command <- commands) {
      command.getText match {
        case "--image" => {
          if (command.getValue.get.endsWith(".jpg") || command.getValue.get.endsWith(".jpeg")) {
            loadedImage = Some(imageLoader.load(command.getValue.get))
          }
          else if (command.getValue.get.contains(".png")) {
            loadedImage = Some(imageLoader.load(command.getValue.get))
          } else {
            throw new IllegalStateException(s"It is not possible to load file ${command.getText} because of it's format.")
          }
        }
        case "--output-file" => {
          if (command.getValue.get.endsWith(".txt")) {
            txtFileASCIIImageExporter.export(convertedImage.get, command.getValue.get)
          } else {
            throw new IllegalStateException(s"It is not possible to export to file ${command.getText} because of it's format. "
              + s"Only .txt format is possible.")
          }
        }
        case "--brightness" => {
          val brightnessFilter: BrightnessASCIIImageFilter = new BrightnessASCIIImageFilter(command.getValue.get)
          converter.addFilter(brightnessFilter)
        }
        case "--flip" => {
          val flipFilter: FlipASCIIImageFilter = new FlipASCIIImageFilter(command.getValue.get)
          converter.addFilter(flipFilter)
        }
        case "--invert" => {
          val invertFilter: InvertASCIIImageFilter = new InvertASCIIImageFilter()
          converter.addFilter(invertFilter)
        }
        case "--table" => {
          command.getValue.get match {
            case "linearBourkes" => //is set by default
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
          consoleASCIIImageExporter.export(convertedImage.get, Console.out)
        }
        case "--convert" => {
          convertedImage = Some(converter.convert(loadedImage.get))
        }
        case _ => throw new IllegalStateException(s"Something went wrong with ${command.getText} command.")
      }
    }
  }

  private def sortCommands(commands: Seq[Argument]): Seq[Argument] = {

    var editedCommands = commands
    var sorted: Seq[Argument] = Seq()

    //add imports
    if (editedCommands.exists(a => a.getText.equals("--image")) && editedCommands.exists(a => a.getText.equals("--image-random"))) {
      throw new IllegalStateException("There are more than one command to import image.")
    }
    if (editedCommands.exists(a => a.getText.equals("--image"))) {
      sorted = sorted.appended(editedCommands.find(a => a.getText.equals("--image")).get)
      editedCommands = editedCommands.dropWhile(a => a.getText.equals("--image"))
    } else if (editedCommands.exists(a => a.getText.equals("--image-random"))) {
      sorted = sorted.appended(editedCommands.find(a => a.getText.equals("--image-random")).get)
      editedCommands = editedCommands.dropWhile(a => a.getText.equals("--image-random"))
    } else {
      throw new IllegalStateException("There is no command --image or --image-random to import any image.")
    }

    //add table and filters
    for (command <- editedCommands) {
      if (command.getText != "--output-console" && command.getText != "--output-file") {
        sorted = sorted.appended(command)
        editedCommands = editedCommands.dropWhile(a => a.getText.equals(command.getText))
      }
    }

    //add own command(flag - time to convert) --convert
    sorted = sorted.appended(Argument("--convert", None))

    //add exports
    for (command <- editedCommands) {
      sorted = sorted.appended(command)
    }

    sorted
  }
}
