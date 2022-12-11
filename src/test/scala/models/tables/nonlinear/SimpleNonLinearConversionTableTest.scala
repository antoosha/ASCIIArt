package models.tables.nonlinear

import org.scalatest.FunSuite

class SimpleNonLinearConversionTableTest extends FunSuite {

  test("Correctly initialized instance, checking values") {
    val tableValues: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    assert(tableValues.equals(conversionTable.getTableValues))
  }

  test("Correctly initialized instance, checking offset") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    assert(100.equals(conversionTable.offset))
  }

  test("Get value by correct index = 0 from table") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    assert(conversionTable.getTableValues(0).equals(conversionTable.getValue(0)))
  }

  test("Get value by correct index = 68(last one) from table") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    assert(conversionTable.getTableValues(68).equals(conversionTable.getValue(68)))
  }

  test("Get value from table by incorrect index < 0") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(-1))
  }

  test("Get value from table by incorrect index > length of table") {
    val conversionTable: SimpleNonLinearConversionTable = SimpleNonLinearConversionTable()
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(tableValuesLength))
  }
}
