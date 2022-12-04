package business.generators

trait Generator[R] {

  def generate(): R
}
