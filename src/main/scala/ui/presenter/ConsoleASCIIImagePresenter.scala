package ui.presenter

import models.images.{ASCIIImage, Image}

import java.io.OutputStream

class ConsoleASCIIImagePresenter[T <: OutputStream, R <: ASCIIImage] extends Presenter[T, R] {

  override def present(os: T, res: R): Unit = {
    // todo implement
  }
}
