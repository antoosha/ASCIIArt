package business.converters.image

import business.converters.Converter
import models.images.Image

trait ImageConverter[T <: Image, R] extends Converter[T, R] {

}
