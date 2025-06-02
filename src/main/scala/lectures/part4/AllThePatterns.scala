package lectures.part4

import exercises.part2OOP.{Cons, Empty, MyList}


object AllThePatterns extends App{

  // 1- contains
//
//  val x: Any = "Scala"
//  val constants = x match {
//    case 1 => "a number"
//    case "Scala" => "The Scala "
//    case true  => "The truth"
//    case AllThePatterns => "A singleton object"
//  }
//
//  // 2 - match anything
//  //2.1 wildcard
//
//
//  val matchAnything: Unit = x match {
//    case _ =>
//  }
//
//  // 2.2 variable
//
//  val matchAVariable = x match {
//    case something => s"I've found $something"
//  }
//
//  // 3. tuples
//
//  val aTuple = (1, 2)
//  val matchATuple = aTuple match {
//    case (1,1) =>
//    case (something, 2) => s"I've found $something"
//  }
//
//  val nestedTuple = (1, (2,3))
//  val matchANestedTuple = nestedTuple match {
//    case (_, (2,v)) =>
//  }
//
//  // PMs can be Nested!
//
//  // 4. case classes - constructor pattern
//
//  val aList:MyList[Int] = Cons(1, Cons(2, Empty))
//
//  val matchList = aList match  {
//    case Empty =>
//    case Cons(head, Cons(subhead, subtail)) =>
//  }
//
//  //5. List patterns
//
//  val aStandardList = List(1,2,3,42)
//  val standardListMatching = aStandardList match  {
//    case List(1, _,_,_) => // extractor pattern
//    case List(1, _*) => // list of arbitrary length - advanced
//    case 1 :: List(_) => // infix pattern
//    case List(1,2,3) :+ 42 =>
//  }
//
//  //6 - type specifiers
//
//  val unknown: Any = 2
//  val unknownMatch = unknown match {
//    case List:List[Int] => // explicit type specifier
//    case _ =>
//
//  }
//
//  // 7 name binding
//
//  val nameBindingMatch = aList match {
//    case nonEmptyList @ Cons(_, _) => //
//    case Cons(1, rest @ Cons(2, _1)) => // name Binding
//  }
//
//  // 8. multi-patterns
//
//  val multiPattern = aList match  {
//    case Empty | Cons(0,_) => // compound pattern
//  }
//
//  // 9 - if guards
//
//  val secondElementSpecial = aList match  {
//    case Cons(_, Cons(specialElement, _))  if specialElement % 2 == 0 =>
//  }

  /*
   Question

   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match  {
    case listOfStrings: List[String] => " a list of strings"
    case listOfNumbers: List[Int] => " a list of numbers"
    case _ => " "
  }
 /*
  // JVM trick question
  we get a list of strings is called TypeErasure, due to which due to generic types
  after type checking it becomes something like this
  list
  */
  println(numbersMatch)


}
