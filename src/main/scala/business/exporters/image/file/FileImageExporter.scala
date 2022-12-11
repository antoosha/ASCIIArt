package business.exporters.image.file

import business.exporters.image.ImageExporter
import models.images.Image

trait FileImageExporter[T <: Image] extends ImageExporter[T] {

}
