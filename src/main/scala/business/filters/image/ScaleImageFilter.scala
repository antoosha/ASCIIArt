package business.filters.image

import models.images.Image

class ScaleImageFilter(private val value: String) extends ImageFilter {

  override def apply: Image = ???

}
