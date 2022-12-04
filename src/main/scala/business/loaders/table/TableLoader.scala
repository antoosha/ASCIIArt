package business.loaders.table

import business.loaders.Loader
import models.tables.ConversionTable

trait TableLoader[P, R <: ConversionTable] extends Loader[P, R] {

}
