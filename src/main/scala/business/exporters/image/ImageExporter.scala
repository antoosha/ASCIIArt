package business.exporters.image

import business.exporters.Exporter
import models.images.Image

trait ImageExporter[I <: Image, P] extends Exporter[I, P] {

}
