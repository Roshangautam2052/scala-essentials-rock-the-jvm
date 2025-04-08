package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // Expression

  println(x)

  println(2 + 3 * 4)
  //  + - * / & ! ^ << >> >>>(right shift with zero extension)

  println(1 == x)

  // == != > >= < <=

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)


  // Instructions(DO) --> they are doing something, tell the computer to do, print to the console (like in java, python), send this to server etc.
  //Expressions  -->  something that has value and or a type or which is evaluated(give me value of something), in functional programming we think in terms of expressions in SCALA
  // for example in
  // IF expression

  val aCondition = true

  val aConditionedValue = if (aCondition) 5 else 3 // This is an expression not an instruction (IF EXPRESSION)

  /*
   This means that aConditionedValue is evaluated to a value based upon the expression if (meaning it is not doing something
  but only evaluating a value)
  if(aCondition) 5 else 3 --> this evaluates to 5
   */

  println(if (aCondition) 5 else 3) //  This is evaluated to a value

  println(aConditionedValue)

  // Everything in SCALA is an expression! only definitions packages, class, val are not instructions

  val aWierdValue = (aVariable = 3) // Unit == void(Reassigning a variable is also a side effect in scala)
  // side effects in scala are expressions which are returning unit, while loop are side effects

  /*
   Examples of side effects are
   println(), whiles, reassigning
   */
  println(aWierdValue)


  // CODE BLOCKS

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "Hello" else "goodbye"
  }

  // code block is also an expression
  // the value of the block is the value of the LAST expression
  // the code block have their own definition of values and are not visible outside

  // 1. difference between "hello world" vs println("hello world")
  //  "hello world" is a value of type string an returns an string while println("hello world ") is an expression which returns Unit type and and it has side effect

  val someValue = {
    2 < 3
  }
  println(someValue)
  // The value of someValue is true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  // the value of someOtherValue is 42
  println(someOtherValue)
}
