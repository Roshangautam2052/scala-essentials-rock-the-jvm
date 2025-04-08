package lectures.part1basics

object Functions extends App {

  // Defining a function in Scala

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("Hello", 3)) // Calling the function is also an expression

  def aParameterLessFunction() : Int = 42

  println(aParameterLessFunction())
  println(aParameterLessFunction())

  def aRepeatedFunction(aString: String, n: Int):String = {
    if( n == 1) aString
    else aString + aRepeatedFunction(aString , n -1)
  }

  println(aRepeatedFunction("hello", 3))

  // Compiler can infer the return type of the expression but if we delete a return type from recursive function it complains
  // Always infer as the return type of a function

  def aFunctionWithSideEffects(aString: String) : Unit = println(aString)


  // code blocks also allows you to define auxiliary functions

  def aBigFunction(n:Int) : Int =
    def aSmallerFunction(a:Int, b:Int): Int = a + b

    aSmallerFunction(n , n -1)

}
