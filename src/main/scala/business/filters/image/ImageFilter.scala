package business.filters.image

import business.filters.Filter
import models.images.Image

/**
 * Interface for filtering an image
 *
 * @tparam T image for filtering
 */
trait ImageFilter[T <: Image] extends Filter[T] {

}
