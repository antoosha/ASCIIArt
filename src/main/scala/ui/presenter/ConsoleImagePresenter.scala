package ui.presenter

import models.images.Image

import java.io.OutputStream

class ConsoleImagePresenter extends Presenter[OutputStream, Image] {

  override def present(os: OutputStream, image: Image): Unit = {


  }
}
