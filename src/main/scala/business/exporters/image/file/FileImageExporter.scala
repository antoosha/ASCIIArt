package business.exporters.image.file

import business.exporters.image.ImageExporter
import models.images.Image

/**
 * Interface for exporting image to file
 *
 * @tparam T image to export
 */
trait FileImageExporter[T <: Image] extends ImageExporter[T] {

}
