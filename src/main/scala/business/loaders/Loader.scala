package business.loaders

trait Loader[R] {

  def load(): R
}
