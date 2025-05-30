package lectures.part2OOP

object Exceptions extends App {

  val x: String = null
  // this throws an exception

  // this will crash with null pointer exception
  // println(x.length)

  //1. throwing exceptions
  //val aWierdValue: String = throw new NullPointerException()

  // throwable classes extend the Throwable class

  // Exception and Error are the major Throwable subtypes

  //2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you !")
    else 42
  }
    val potentialFail = try {
      // code that might throw exceptions
      getInt(true)
    } catch {
      // This will catch exception
      case e: NullPointerException => 12
    } finally {
      // This is optional and does not influence the return type of an expression
      // code that will get executed NO MATTER WHAT
      
      // use finally only for side effects 
      println("finally")
    }
    
    // How to define our own exceptions 
    
  class MyExceptions extends Exception
  val exception = new MyExceptions
  

  /**
   *  1. Crash program with an OutOfMemoryError 
   *  2. Crash with stackoverflow error 
   *  3. Pocket calculator 
   *    // add(x,y)
   *    // subtract(x,y)
   *    // divide(x,y)
   *    // multiply (x,y)
   *    
   *    Throw 
   *     -- OverflowException if add(x,y) exceeds Int.MAX_VALUE
   *     --UnderflowException if subtract(x,y) exceeds Int.Min_Value
   *     --MathCalculationException for division by 0
   */
}

