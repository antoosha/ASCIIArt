package business.exporters.image

import business.exporters.Exporter
import models.images.Image

/**
 * Interface for exporing Image
 *
 * @tparam T image to export
 */
trait ImageExporter[T <: Image] extends Exporter[T] {

}
