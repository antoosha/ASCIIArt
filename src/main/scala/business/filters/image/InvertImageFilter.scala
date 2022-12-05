package business.filters.image
import models.images.Image

class InvertImageFilter(private val value: String) extends ImageFilter {

  override def apply: Image = ???
}
