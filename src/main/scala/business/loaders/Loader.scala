package business.loaders

trait Loader[P, R] {

  def load(path: P): R
}
