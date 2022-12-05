package business.filters.image

import models.images.Image

class RotateImageFilter(private val value: String) extends ImageFilter {

  override def apply: Image = ???

}
