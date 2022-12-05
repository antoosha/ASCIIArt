package business.converters

trait Converter[T, R] {
  def convert(item: T): R
}
