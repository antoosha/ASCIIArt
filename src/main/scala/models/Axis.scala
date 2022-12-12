package models

/**
 * Represents Axis of coordinate system
 */
object Axis extends Enumeration {

  type Axis = Value

  val X: Value = Value("x")
  val Y: Value = Value("y")
}
