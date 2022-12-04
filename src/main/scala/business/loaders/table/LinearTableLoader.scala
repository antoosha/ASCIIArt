package business.loaders.table

import business.loaders.Loader
import models.tables.LinearConversionTable

class LinearTableLoader extends Loader[String, LinearConversionTable] {

  override def load(path: String): LinearConversionTable = {

    // todo write logic
    LinearConversionTable()
  }
}
