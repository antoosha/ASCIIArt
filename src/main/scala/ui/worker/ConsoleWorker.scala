package ui.worker

import business.converters.image.{GrayscaleToASCIIImageConverter, RGBToGrayscaleImageConverter}
import business.exporters.image.console.ConsoleASCIIImageExporter
import business.exporters.image.file.TxtFileASCIIImageExporter
import business.filters.image.grayscale.{BrightnessGrayscaleImageFilter, FlipGrayscaleImageFilter, InvertGrayscaleImageFilter}
import business.loaders.image.RandomImageLoader
import business.loaders.image.file.{JpgImageLoader, PngImageLoader}
import models.images.{ASCIIImage, GrayscaleImage, RGBImage}
import models.tables.linear.UserLinearConversionTable
import models.tables.nonlinear.SimpleNonLinearConversionTable
import models.{Argument, Axis}
import ui.parser.{ConsoleParser, Parser}

class ConsoleWorker extends Worker[Argument] {

  private val parser: Parser[Seq[String], Seq[Argument]] = new ConsoleParser
  private val randomImageLoader: RandomImageLoader = new RandomImageLoader()
  private val rgbToGrayscaleImageConverter: RGBToGrayscaleImageConverter = RGBToGrayscaleImageConverter()
  private val grayscaleToASCIIImageConverter: GrayscaleToASCIIImageConverter = new GrayscaleToASCIIImageConverter()

  override def work(args: Seq[String]): Seq[Argument] = {

    resolveCommands(sortCommands(parser.parse(args)))
  }

  private def resolveCommands(commands: Seq[Argument]): Seq[Argument] = {

    var loadedImage: Option[RGBImage] = None
    var convertedImage: Option[ASCIIImage] = None

    for (command <- commands) {
      command.getText match {
        case "--image" => {
          if (command.getValue.get.endsWith(".jpg") || command.getValue.get.endsWith(".jpeg")) {
            val jpgImageLoader: JpgImageLoader = new JpgImageLoader(command.getValue.get)
            loadedImage = Some(jpgImageLoader.load())
          }
          else if (command.getValue.get.contains(".png")) {
            val pngImageLoader: PngImageLoader = new PngImageLoader(command.getValue.get)
            loadedImage = Some(pngImageLoader.load())
          } else {
            throw new IllegalStateException(s"It is not possible to load file ${command.getText} because of it's format.")
          }
        }
        case "--output-file" => {
          if (command.getValue.get.endsWith(".txt")) {
            new TxtFileASCIIImageExporter(command.getValue.get).export(convertedImage.get)
          } else {
            throw new IllegalStateException(s"It is not possible to export to file ${command.getText} because of it's format. "
              + s"Only .txt format is possible.")
          }
        }
        case "--brightness" => {
          val brightnessFilter: BrightnessGrayscaleImageFilter = new BrightnessGrayscaleImageFilter(command.getValue.get)
          rgbToGrayscaleImageConverter.addFilter(brightnessFilter)
        }
        case "--flip" => {
          if (command.getValue.get.toLowerCase() == Axis.X.toString) {
            rgbToGrayscaleImageConverter.addFilter(new FlipGrayscaleImageFilter(Axis.X))
          } else if (command.getValue.get.toLowerCase() == Axis.Y.toString) {
            rgbToGrayscaleImageConverter.addFilter(new FlipGrayscaleImageFilter(Axis.Y))
          }
          else {
            throw new IllegalStateException(s"There is no known axis as: ${command.getValue.get}. Only X and Y is possible. ")
          }
        }
        case "--invert" => {
          val invertFilter: InvertGrayscaleImageFilter = new InvertGrayscaleImageFilter()
          rgbToGrayscaleImageConverter.addFilter(invertFilter)
        }
        case "--table" => {
          command.getValue.get match {
            case "linearBourkes" => //is set by default
            case "nonLinearSimple" => grayscaleToASCIIImageConverter.setTable(SimpleNonLinearConversionTable())
            case _ => throw new IllegalStateException(s"Table name ${command.getValue.get} does not exist.")
          }
        }
        case "--custom-table" => {
          grayscaleToASCIIImageConverter.setTable(new UserLinearConversionTable(command.getValue.get))
        }
        case "--image-random" => {
          loadedImage = Some(randomImageLoader.load())
        }
        case "--output-console" => {
          new ConsoleASCIIImageExporter(Console.out).export(convertedImage.get)
        }
        case "--convert" => {
          val grayscaleImage: GrayscaleImage = rgbToGrayscaleImageConverter.convert(loadedImage.get)
          convertedImage = Some(grayscaleToASCIIImageConverter.convert(grayscaleImage))
        }
        case _ => throw new IllegalStateException(s"Something went wrong with ${command.getText} command.")
      }
    }

    commands
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
    sorted = sorted.appended(new Argument("--convert", None))

    //add exports
    for (command <- editedCommands) {
      sorted = sorted.appended(command)
    }

    sorted
  }
}
