package business.filters

trait Filter[R] {

  def apply(image: R): R
}
