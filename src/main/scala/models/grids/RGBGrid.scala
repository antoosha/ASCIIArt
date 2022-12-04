package models.grids

import models.pixels.RGBPixel

import scala.collection.mutable.ListBuffer

case class RGBGrid(pixelMatrix: ListBuffer[ListBuffer[RGBPixel]]) extends Grid[RGBPixel] {

}
