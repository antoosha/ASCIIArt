package ui.presenter

import java.io.OutputStream


class ConsoleTextPresenter[T <: OutputStream] extends Presenter[T, String] {

  override def present(os: T, res: String): Unit = {
    os.write(res.getBytes())
  }

}
