package models.tables.linear

import org.scalatest.FunSuite

class PaulBourkesLinearConversionTableTest extends FunSuite {

  test("Correctly initialized instance") {
    val tableValues: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
    val conversionTable: PaulBourkesLinearConversionTable = PaulBourkesLinearConversionTable()
    assert(tableValues.equals(conversionTable.getTableValues))
    assert(0.equals(conversionTable.offset))
  }

  test("Get value by correct index = 0 from table") {
    val conversionTable: PaulBourkesLinearConversionTable = PaulBourkesLinearConversionTable()
    assert(conversionTable.getTableValues(0).equals(conversionTable.getValue(0)))
  }

  test("Get value by correct index = 10 from table") {
    val conversionTable: PaulBourkesLinearConversionTable = PaulBourkesLinearConversionTable()
    assert(conversionTable.getTableValues(10).equals(conversionTable.getValue(10)))
  }

  test("Get value by correct index = 68(last one) from table") {
    val conversionTable: PaulBourkesLinearConversionTable = PaulBourkesLinearConversionTable()
    assert(conversionTable.getTableValues(68).equals(conversionTable.getValue(68)))
  }

  test("Get value from table by incorrect index > length of the table") {
    val conversionTable: PaulBourkesLinearConversionTable = PaulBourkesLinearConversionTable()
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(tableValuesLength))
  }

  test("Get value from table by incorrect index < 0") {
    val conversionTable: PaulBourkesLinearConversionTable = PaulBourkesLinearConversionTable()
    val tableValuesLength: Int = conversionTable.getTableValues.length
    assertThrows[IllegalStateException](conversionTable.getValue(-1))
  }
}
