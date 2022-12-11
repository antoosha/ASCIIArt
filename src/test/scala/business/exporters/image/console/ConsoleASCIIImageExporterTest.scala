package business.exporters.image.console

import models.grids.pixel.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class ConsoleASCIIImageExporterTest extends FunSuite {

  test("Export to console 1x1 correct image") {

    val os: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(os)
    val exporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter(printStream)

    val asciiPixel: ASCIIPixel = ASCIIPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage)
    assert("U\r\n".equals(os.toString))
  }

  test("Export to console 1x2 correct image") {

    val os: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(os)
    val exporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter(printStream)

    val asciiPixel: ASCIIPixel = ASCIIPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage)
    assert("UU\r\n".equals(os.toString))
  }

  test("Export to console 0x0 incorrect image") {

    val os: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(os)
    val exporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter(printStream)

    val pixelRow: Seq[ASCIIPixel] = Seq.empty
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage)
    assert("\r\n".equals(os.toString))
  }
}
