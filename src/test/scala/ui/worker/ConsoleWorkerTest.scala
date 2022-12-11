package ui.worker

import models.Argument
import org.scalatest.FunSuite

class ConsoleWorkerTest extends FunSuite {

  def flip: String = "--flip"

  def invert: String = "--invert"

  def brightness: String = "--brightness"

  def imageRandom: String = "--image-random"

  def image: String = "--image"

  def outputConsole: String = "--output-console"

  def outputFile: String = "--output-file"

  def table: String = "--table"

  def customTable: String = "--custom-table"


  test("Incorrect empty input.") {
    val arguments: Seq[String] = Seq.empty
    val consoleWorker: ConsoleWorker = new ConsoleWorker()
    assertThrows[IllegalStateException](consoleWorker.work(arguments))
  }

  test("Resolved commands: image from file, no filters, no tables, export to console") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$image")
    arguments = arguments.appended("images/image1.png")
    arguments = arguments.appended(s"$outputConsole")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$image", Some("images/image1.png")))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputConsole", None))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: image from random generator, no filters, no tables, export to console") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$imageRandom")
    arguments = arguments.appended(s"$outputConsole")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$imageRandom", None))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputConsole", None))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: image from file, no filters, no tables, export to file") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$image")
    arguments = arguments.appended("images/image1.png")
    arguments = arguments.appended(s"$outputFile")
    arguments = arguments.appended("output.txt")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$image", Some("images/image1.png")))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputFile", Some("output.txt")))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: image from file, all filters, no tables, export to console") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$image")
    arguments = arguments.appended("images/image1.png")
    arguments = arguments.appended(s"$flip")
    arguments = arguments.appended("x")
    arguments = arguments.appended(s"$invert")
    arguments = arguments.appended(s"$brightness")
    arguments = arguments.appended("-100")
    arguments = arguments.appended(s"$outputConsole")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$image", Some("images/image1.png")))
    resultArguments = resultArguments.appended(new Argument(s"$flip", Some("x")))
    resultArguments = resultArguments.appended(new Argument(s"$invert", None))
    resultArguments = resultArguments.appended(new Argument(s"$brightness", Some("-100")))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputConsole", None))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: image from file, no filters, linear named table, export to console") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$image")
    arguments = arguments.appended("images/image1.png")
    arguments = arguments.appended(s"$table")
    arguments = arguments.appended("linearBourkes")
    arguments = arguments.appended(s"$outputConsole")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$image", Some("images/image1.png")))
    resultArguments = resultArguments.appended(new Argument(s"$table", Some("linearBourkes")))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputConsole", None))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: image from file, no filters, linear user's table, export to console") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$image")
    arguments = arguments.appended("images/image1.png")
    arguments = arguments.appended(s"$customTable")
    arguments = arguments.appended("$#5o.")
    arguments = arguments.appended(s"$outputConsole")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$image", Some("images/image1.png")))
    resultArguments = resultArguments.appended(new Argument(s"$customTable", Some("$#5o.")))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputConsole", None))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: image from file, no filters, nonlinear named table, export to console") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended(s"$image")
    arguments = arguments.appended("images/image1.png")
    arguments = arguments.appended(s"$table")
    arguments = arguments.appended("nonLinearSimple")
    arguments = arguments.appended(s"$outputConsole")

    var resultArguments: Seq[Argument] = Seq.empty
    resultArguments = resultArguments.appended(new Argument(s"$image", Some("images/image1.png")))
    resultArguments = resultArguments.appended(new Argument(s"$table", Some("nonLinearSimple")))
    resultArguments = resultArguments.appended(new Argument("--convert", None))
    resultArguments = resultArguments.appended(new Argument(s"$outputConsole", None))
    val consoleWorker: ConsoleWorker = new ConsoleWorker()

    val resolvedCommands: Seq[Argument] = consoleWorker.work(arguments)
    assert(resultArguments.length.equals(resolvedCommands.length))
    for (i <- resultArguments.indices) {
      assert(resultArguments(i).equals(resolvedCommands(i)))
    }
  }

  test("Resolved commands: not existing command") {
    var arguments: Seq[String] = Seq.empty
    arguments = arguments.appended("--some-command")
    val consoleWorker: ConsoleWorker = new ConsoleWorker()
    assertThrows[IllegalStateException](consoleWorker.work(arguments))
  }
}
