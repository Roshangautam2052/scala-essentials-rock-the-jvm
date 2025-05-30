package lectures.part3fp

object AnonymousFunction extends App{

  /*
   This is still the Object oriented way of creating an anonymous function

   */
  val doubler = new Function1[Int, Int] {
    override def apply(value1: Int) = value1 * 2
  }

  println(doubler(12))

  // The more functional way of instantiating an anonymous function or lambda (comes from lambda calculus) is as follows
  // anonymous Function(LAMBDA)
  val doubler2 = (x: Int) => x * 2

  // we can also write this as we need to specify
  val doubler3: Int => Int = x => x * 2

  println(doubler2(12))

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a:Int, b:Int) => a + b

  // no parameters lambda

  val justDoSomething: () => Int = () => 3

  println(justDoSomething)// function itself

  // when calling a labda we must call it with parenthesis
  println(justDoSomething()) // this is the actual call

  // curly braces with lambda
  val stringToInt = { (str:String) =>
    str.toInt
  }

  // More syntactic sugar

  val nicerIncrementer:Int  => Int = _ + 1 // equivalent to x  => x  + 1

  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
   Go to MyList: replace all FunctionX calls with lambdas
   */
  /*
    Rewrite the "special" adder as an anonymous function 
   */
}
