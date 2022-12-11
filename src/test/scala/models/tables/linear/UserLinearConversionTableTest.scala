package models.tables.linear

import org.scalatest.FunSuite

class UserLinearConversionTableTest extends FunSuite {

  test("Correctly initialized instance, checking length of table") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    assert(tableValues.equals(conversionTable.getTableValues))
  }

  test("Correctly initialized instance, checking offset") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    assert(0.equals(conversionTable.offset))
  }

  test("Incorrectly initialized instance") {
    val emptyTableValues: String = ""
    assertThrows[IllegalArgumentException](new UserLinearConversionTable(emptyTableValues))
  }

  test("Get value by correct index = 0 from table") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    assert(conversionTable.getTableValues(0).equals(conversionTable.getValue(0)))
  }

  test("Get value by correct index = 4(last one) from table") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    assert(conversionTable.getTableValues(4).equals(conversionTable.getValue(4)))
  }

  test("Get value from table by incorrect index > length of table") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(tableValuesLength))
  }

  test("Get value from table by incorrect index < 0") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(-1))
  }
}
