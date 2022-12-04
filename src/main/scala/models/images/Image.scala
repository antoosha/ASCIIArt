package models.images

import models.pixels.Pixel

trait Image {

  def getPixel(x: Int, y: Int): Pixel

  def getHeight: Int

  def getWidth: Int

}
