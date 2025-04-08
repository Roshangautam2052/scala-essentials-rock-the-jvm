package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long):Unit = {
    println("by value :" + x)
    println("by value:" + x)
  }

  def calledByName(x: => Long):Unit = {
    println("by name:" + x)
    println("by name:" + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /*
   Here in calledByValue the System.nanoTime() is evaluated and then passed into the function
  But in calledByName : => the System.naoTime() parameter or expression is passed inside the function
  and is evaluated at every use with the implementation.
   */

  def infinite(): Int = 1 + infinite()
  def printFirst(x:Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) this will crash with stack overflow

  printFirst(34, infinite()) // This will not break the stack overflow as the infinite value is not evaluated

}
