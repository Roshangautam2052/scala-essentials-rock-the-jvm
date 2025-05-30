package lectures.part3fp

import scala.annotation.tailrec

object  HOFsCurries extends App{

  // how to read this function
  // (Int, (String, Int => Boolean) =>Int) => Int => Int  returns an Int function which takes a function by taking a Int and another function
  // the function which takes function as an input and returns another function as result is called higher order function(HOF)
  val superFunction: (Int, (String, Int => Boolean) => Int) => (Int => Int) =  null


  // function that applies another function n times over a value x

  // nTimes(f, n,x)
  // nTimes(f, 3, x) = f(f(f(x)))

  @tailrec
  private def nTimes(f: Int => Int, n: Int, x:Int): Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  private val linearFunction = (x:Int) => 3*x + 6

  println(nTimes(linearFunction, 4, 1))

  private def nTimesBetter(f:Int => Int, n:Int):(Int => Int) = {
    if (n <=0) (x:Int) => x
    else (x:Int) => nTimesBetter(f, n-1) (f(x))
  }
  private val linearFunctionOutput = nTimesBetter(linearFunction, 4)
  println(linearFunctionOutput(1))

  // curried functions

  val superAdder: Int => (Int => Int) = (x:Int) => (y:Int) => x + y

  val add4 = superAdder(12)

  // These two values are equal
  println(add4(14))
  println(superAdder(12)(14))

  // functions with multiple parameter lists

  private def curriedFormatter(c:String)(d:Double): String = c.format(d)

  private val standardFormatter:(Double => String) = curriedFormatter("%4.2f")

  private val preciseFormatter: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(preciseFormatter(Math.PI))
}
