package business.filters

trait Filter[R] {

  def apply: R
}
