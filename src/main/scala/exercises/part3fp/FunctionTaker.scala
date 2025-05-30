package exercises.part3fp

object FunctionTaker extends App{

  // Type the function takes Function1[Int, Function1[Int, Int]]

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override  def apply(x:Int) = new Function1[Int, Int] {
      override def apply(y:Int) =  x + y
    }
  }

  val adder3 = superAdder(3) // This returns a function
  println(adder3(4)) // this will then apply the value 4 to the return function

  // Also we can do sth like this
  val adder4 = superAdder(3)(4) // Here the supperAdder(3) returns a Function1 and it calls the Function1 takes 4 as an argument and adds x and y
   // this implementation technique is called curried function(can be called with multiple parameter lists)


   val superAdder4m=  (x:Int) => (y:Int) => x + y

}
