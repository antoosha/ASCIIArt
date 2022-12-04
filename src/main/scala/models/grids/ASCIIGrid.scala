package models.grids

import models.pixels.ASCIIPixel

case class ASCIIGrid(charMatrix: List[List[Int]]) extends Grid[ASCIIPixel] {

}
