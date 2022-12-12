package business.loaders.image.file

import business.loaders.image.ImageLoader
import models.images.Image

/**
 * Interface for loading image from file
 *
 * @tparam R loaded item
 */
trait FileImageLoader[R <: Image] extends ImageLoader[R] {

}
