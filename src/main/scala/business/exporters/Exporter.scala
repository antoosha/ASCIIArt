package business.exporters

trait Exporter[T] {

  def export(item: T): Unit

}
