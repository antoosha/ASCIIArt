package business.exporters

trait Exporter[I, P] {

  def export(item: I, out: P): Unit

}
