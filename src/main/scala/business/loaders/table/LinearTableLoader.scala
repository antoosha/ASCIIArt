package business.loaders.table

import models.tables.linear.{LinearConversionTable, PaulBrokesLinearConversionTable}

//todo change in LinearConversionTable[String] String to T
class LinearTableLoader extends TableLoader[String, LinearConversionTable[String]] {

  override def load(path: String): LinearConversionTable[String] = {

    // todo write logic
    PaulBrokesLinearConversionTable()
  }
}
