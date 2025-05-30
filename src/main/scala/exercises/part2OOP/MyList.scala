package exercises.part2OOP

/*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString() => a string representation of the list

     */

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  // higher order functions: receives a function as parameter or return another function as result
  def map[B](myTransformer: A => B): MyList[B]

  def filter(myPredicate: A => Boolean): MyList[A]

  def flatMap[B](myTransformer:A => MyList[B]): MyList[B]

  // concatenation
  def ++[B >:A](list: MyList[B]): MyList[B]

  def printElements: String

  // polymorphic call 
  //override def toString: String = "[" + printElements + "]"


}
/*
trait MyPredicate[-T] { // T => Boolean

  def test(element: T): Boolean
}

trait MyTransformer[-A, B] { // A => B

  def transform(element: A): B
}
 */



case object Empty extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""


  override def map[B](myTransformer: Nothing =>B ): MyList[B] = Empty

  override def filter(myPredicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def flatMap[B](myTransformer: Nothing => MyList[B]): MyList[B] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] =  list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements
  }

  /*
   [1,2,3].map(n*2)
    = new Cons(2, [2,3].map(n*2))
    = new Cons(2, new Cons(4, [3].map(n *2)))
    = new Cons(2,new Cons(4, new Cons(6, Empty.map(n *2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty))))
   */
  override def map[B](myTransformer: A => B): MyList[B] =
     Cons(myTransformer(h), t.map(myTransformer))

  /*
   [1,2,3].filter (n % 2 == 0) =
  [2,3].filter (n % 2 == 0 ) =
  = new Cons(2, [3].filter(n % 2 == 0))
  = new Cons(2, Empty.filter( n % 2 == 0))
  = new Cons(2, Empty)
   */

  override def filter(myPredicate: A => Boolean): MyList[A] =
    if (myPredicate(h))  Cons(h, t.filter(myPredicate))
    else t.filter(myPredicate)

  /*
   [1,2] ++ [3,4,5]
   = new Cons[1, [2] ++ [3,4,5])
   = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, new Cons(2, new Cons(4, new Cons(5))))
   */
  override def ++[B >: A](list: MyList[B]): MyList[B] =  Cons(h, t ++ list)

  /*
    [1,2].flatMap(n => [n, n +1]
   = [1,2] ++ [2].flatMap (n => [n, n+1])
   = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n +1])
   = [1,2] ++ [2,3] ++ Empty
   = [1,2,2,3]

   */
  override def flatMap[B](myTransformer: A  => MyList[B]): MyList[B] =
    myTransformer(h) ++ t.flatMap(myTransformer)
}

object ListTest extends App {

  val listOfIntegers: MyList[Int] =  Cons(1, new Cons[Int](2, new Cons[Int](3, Empty)))
  
  val cloneListOfIntegers: MyList[Int] =  Cons(1, new Cons[Int](2, new Cons[Int](3, Empty)))

  val anotherListOfIntegers: MyList[Int] = Cons(4, new Cons[Int](5,  Empty))

  val listOfStrings: MyList[String] = Cons("Hello", Cons("World",  Cons("Nepal", Empty)))

  println(listOfStrings.toString)
  println(listOfIntegers.toString)
  
  // By conversion of the class into case class
  println(listOfIntegers == cloneListOfIntegers)
  // These are anonymous class
  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(element: Int): Int = element * 2
  })).toString

  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply (element: Int): Boolean = element % 2 == 0
  })).toString

  println(listOfIntegers ++ anotherListOfIntegers).toString

  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem +1, Empty))
  })).toString

  // more functional way of calling the above methods

  println(listOfIntegers.map(elem => elem * 2)).toString
  // also can be written
  println(listOfIntegers.map(_ * 2)).toString
  println(listOfIntegers.filter(elem => elem % 2 == 0)).toString
  // Also can be written
  println(listOfIntegers.filter(_ % 2 == 0)).toString
  println(listOfIntegers.flatMap(elem => Cons(elem +1, Empty))).toString


}
