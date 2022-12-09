package models.tables.nonlinear

import org.scalatest.FunSuite

class SimpleNonLinearConversionTableTest extends FunSuite {

  test("Correctly initialized instance") {
    val tableValues: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    assert(tableValues.equals(conversionTable.getTableValues))
    assert(100.equals(conversionTable.offset))
  }

  test("Get value by correct index from table") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    for (i <- 0 until conversionTable.getTableValues.length by 1) {
      assert(conversionTable.getTableValues(i).equals(conversionTable.getValue(i)))
    }
  }

  test("Get value by incorrect index from table") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(tableValuesLength))
    assertThrows[IllegalStateException](conversionTable.getValue(-1))
  }
}
