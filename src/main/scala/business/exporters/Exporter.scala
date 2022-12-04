package business.exporters

trait Exporter[I, P] {

  def export(item: I, path: Option[P]): Unit

}
