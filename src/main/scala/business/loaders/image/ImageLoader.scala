package business.loaders.image

import business.loaders.Loader
import models.images.Image

/**
 * Interface for image loading
 *
 * @tparam R loaded item
 */
trait ImageLoader[R <: Image] extends Loader[R] {

}
