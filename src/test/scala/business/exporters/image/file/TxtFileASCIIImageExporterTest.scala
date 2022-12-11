package business.exporters.image.file

import models.grids.pixel.ASCIIGrid
import models.images.ASCIIImage
import models.pixels.ASCIIPixel
import org.scalatest.FunSuite

import scala.io.Source

class TxtFileASCIIImageExporterTest extends FunSuite {

  val path: String = "src/test/resources/test-output.txt"
  val exporter: TxtFileASCIIImageExporter = new TxtFileASCIIImageExporter(path)

  test("Export to console 1x1 correct image") {
    val asciiPixel: ASCIIPixel = ASCIIPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage)
    val bufferedSource = Source.fromFile(path)
    assert("U" == bufferedSource.getLines().mkString)
    bufferedSource.close
  }

  test("Export to console 1x2 correct image") {
    val asciiPixel: ASCIIPixel = ASCIIPixel('U')
    var pixelRow: Seq[ASCIIPixel] = Seq.empty
    pixelRow = pixelRow.appended(asciiPixel)
    pixelRow = pixelRow.appended(asciiPixel)

    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage)
    val bufferedSource = Source.fromFile(path)
    assert("UU" == bufferedSource.getLines().mkString)
    bufferedSource.close
  }

  test("Export to console 0x0 incorrect image") {
    val pixelRow: Seq[ASCIIPixel] = Seq.empty
    var pixelGrid: Seq[Seq[ASCIIPixel]] = Seq.empty
    pixelGrid = pixelGrid.appended(pixelRow)

    val asciiPixelGrid: ASCIIGrid = ASCIIGrid(pixelGrid)
    val asciiImage: ASCIIImage = ASCIIImage(asciiPixelGrid)

    exporter.export(asciiImage)
    val bufferedSource = Source.fromFile(path)
    assert("" == bufferedSource.getLines().mkString)
    bufferedSource.close
  }
}
