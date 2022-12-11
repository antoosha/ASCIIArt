package business.loaders.image

import business.loaders.Loader
import models.images.Image

trait ImageLoader[R <: Image] extends Loader[R] {

}
