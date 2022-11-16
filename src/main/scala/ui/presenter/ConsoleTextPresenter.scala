package ui.presenter

import java.io.OutputStream


class ConsoleTextPresenter extends Presenter[OutputStream, String] {

  override def present(os: OutputStream, text: String): Unit = {

    os.write(text.getBytes())
  }


}
