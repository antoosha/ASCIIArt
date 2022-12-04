package business.loaders.image.file

import business.loaders.image.ImageLoader
import models.images.Image

trait FileImageLoader[P, R <: Image] extends ImageLoader[P, R] {

}
