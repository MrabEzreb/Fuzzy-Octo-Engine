package mrabezreb.fuzzyocto

import processing.core.PApplet
import scala.collection.mutable.ArrayBuffer
import mrabezreb.fuzzyocto.binding.Bound

class Main extends PApplet {
  override def settings() = {
    size(Main.settingObj.windowWidth, Main.settingObj.windowHeight, Main.settingObj.renderMethod)
    Main.bound.foreach { b => b.settings() }
  }
  
  override def setup() = {
    camera()
    frameRate(60)
    Main.bound.foreach { b => b.setup() }
  }
  
  var count = 0
  var rot = 0f
  
  override def draw() = {
    background(255, 0, 255)
    translate(count+127, count+127, 0)
    rotateY(rot * (processing.core.PConstants.PI / 180.0f))
    count += 1
    count %= 255
    rot += 1f
    rot %= 360f
    fill(255)
    box(50)
    Main.bound.foreach { b => b.draw() }
  }
}

object Main {
  
  val bound = new ArrayBuffer[Bound]
  
  var settingObj: Settings = null
  
  def main(settingsObj: Settings): Unit = {
    settingObj = settingsObj
    PApplet.main("mrabezreb.fuzzyocto.Main")
  }
  
  def main(args: Array[String]): Unit = {
    val m = new Settings(500, 500, processing.core.PConstants.P3D)
    println(processing.core.PConstants.P3D)
    println(processing.core.PConstants.JAVA2D)
    main(m)
  }
}