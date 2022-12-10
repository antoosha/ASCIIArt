package business.exporters.image.file

import models.grids.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

import scala.io.Source

class TxtFileASCIIImageExporterTest extends FunSuite {

  val exporter: TxtFileASCIIImageExporter = new TxtFileASCIIImageExporter

  test("Export to console 1x1 correct image") {
    val asciiPixel: ASCIIPixel = new ASCIIPixel(100)
    asciiPixel.setPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage, "src/test/resources/test-output.txt")
    val bufferedSource = Source.fromFile("src/test/resources/test-output.txt")
    assert("U" == bufferedSource.getLines().mkString)
    bufferedSource.close
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

    exporter.export(asciiImage, "src/test/resources/test-output.txt")
    val bufferedSource = Source.fromFile("src/test/resources/test-output.txt")
    assert("UU" == bufferedSource.getLines().mkString)
    bufferedSource.close
  }

  test("Export to console 0x0 incorrect image") {
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage, "src/test/resources/test-output.txt")
    val bufferedSource = Source.fromFile("src/test/resources/test-output.txt")
    assert("" == bufferedSource.getLines().mkString)
    bufferedSource.close
  }
}
