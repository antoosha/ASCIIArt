package business.exporters.image.console

import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class ConsoleASCIIImageExporterTest extends FunSuite {

  val exporter: ConsoleASCIIImageExporter = new ConsoleASCIIImageExporter

  test("Export to console 1x1 correct image") {
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    asciiPixel.setPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    val os: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(os)
    printStream.flush()

    exporter.export(asciiImage, printStream)
    assert("U\r\n".equals(os.toString))
  }

  test("Export to console 1x2 correct image") {
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    asciiPixel.setPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    val os: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(os)
    printStream.flush()

    exporter.export(asciiImage, printStream)
    assert("UU\r\n".equals(os.toString))
  }

  test("Export to console 0x0 incorrect image") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)
    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    val os: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(os)
    printStream.flush()

    exporter.export(asciiImage, printStream)
    assert("\r\n".equals(os.toString))
  }
}
