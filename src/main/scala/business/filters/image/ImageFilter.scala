package business.filters.image

import business.filters.Filter
import models.images.Image

trait ImageFilter[T <: Image] extends Filter[T] {

}
