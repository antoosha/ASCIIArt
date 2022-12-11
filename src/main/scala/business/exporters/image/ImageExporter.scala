package business.exporters.image

import business.exporters.Exporter
import models.images.Image

trait ImageExporter[T <: Image] extends Exporter[T] {

}
