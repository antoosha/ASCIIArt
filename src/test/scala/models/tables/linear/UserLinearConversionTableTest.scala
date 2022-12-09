package models.tables.linear

import org.scalatest.FunSuite

class UserLinearConversionTableTest extends FunSuite {

  test("Correctly initialized instance") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    assert(tableValues.equals(conversionTable.getTableValues))
    assert(0.equals(conversionTable.offset))
  }

  test("Incorrectly initialized instance") {
    val emptyTableValues: String = ""
    assertThrows[IllegalArgumentException](new UserLinearConversionTable(emptyTableValues))
  }

  test("Get value by correct index from table") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    for (i <- 0 until conversionTable.getTableValues.length by 1) {
      assert(conversionTable.getTableValues(i).equals(conversionTable.getValue(i)))
    }
  }

  test("Get value by incorrect index from table") {
    val tableValues: String = "01234"
    val conversionTable: UserLinearConversionTable = new UserLinearConversionTable(tableValues)
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(tableValuesLength))
    assertThrows[IllegalStateException](conversionTable.getValue(-1))
  }
}
