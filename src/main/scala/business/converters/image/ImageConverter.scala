package business.converters.image

import business.converters.Converter
import models.images.Image

/**
 * Interface for image conversions
 *
 * @tparam T image to convert
 * @tparam R converted image
 */
trait ImageConverter[T <: Image, R] extends Converter[T, R] {

}
