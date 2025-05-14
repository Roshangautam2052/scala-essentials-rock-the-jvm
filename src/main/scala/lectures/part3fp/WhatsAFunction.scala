package lectures.part3fp

object WhatsAFunction extends App {


  // Dream: use function as first class elements
  // problem: we come from an oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element:Int): Int = element * 2
  }

  // doubler which is like an instance of a function like class can be called as a Function
  // scala supports this function types and the function type are Function 1 --> Function22
  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string:String): Int = string.toInt
  }

  println(stringToIntConverter("12"))

  val adder:((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a:Int, b:Int): Int = a + b
  }
  // Function types Function2[A, B, R] == (A, B) => R
  // All scala functions are objects or instances of classes deriving from Function1, Function2, Function3
}


trait MyFunction[A, B] {
    def apply(element:A):B
  }


