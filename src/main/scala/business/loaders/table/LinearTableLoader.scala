package business.loaders.table

import models.tables.LinearConversionTable

class LinearTableLoader extends TableLoader[String, LinearConversionTable] {

  override def load(path: String): LinearConversionTable = {

    // todo write logic
    LinearConversionTable()
  }
}
