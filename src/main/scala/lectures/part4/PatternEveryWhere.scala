package lectures.part4

object PatternEveryWhere extends App{

  try {
  } catch  {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }
  // catches are actually Matches

  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  }yield 10 * x

  // generators are also based on Pattern Matching

  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  }yield first * second

  // big idea
  val tuple = (1,2,3)
  val (a, b, c) = tuple

  println(b)
  //multiple value definitions based on Pattern Matching
  // All the power

  val head :: tail = list
  println(head)
  println(tail)

  // partial function
  // partial functions are based on pattern matching
  val mappedList = list.map {
    case v if v % 2 == 0 => v + "is even"
    case 1  => "the one"
    case _ => "something else"

  }

  val mappedList2 = list.map {
    case v if v % 2 == 0 => v + "is even"
    case 1  => "the one"
    case _ => "something else"
  }

  println(mappedList)

}
