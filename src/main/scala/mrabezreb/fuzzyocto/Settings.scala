package mrabezreb.fuzzyocto

class Settings(val windowWidth: Int, val windowHeight: Int, val renderMethod: String) {
  
  def this(width: Int, height: Int) = {
    this(width, height, "P2D")
  }
}