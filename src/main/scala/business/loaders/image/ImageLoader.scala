package business.loaders.image

import business.loaders.Loader
import models.images.Image

trait ImageLoader[P, R <: Image] extends Loader[P, R] {

}
