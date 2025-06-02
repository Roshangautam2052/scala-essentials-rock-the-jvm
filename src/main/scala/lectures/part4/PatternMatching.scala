package lectures.part4

import scala.util.Random

object PatternMatching extends App{

  // switch on steroids

  val random = new Random
  val x = random.nextInt(10)


  val description = x match  {
    case 1  => " the one"
    case 2  => "double or nothing "
    case 3 =>  " third time is the charm"
    case _ =>  "something else"

  }

  println(x)
  println(description)

  // 1. Decompose values mostly used for case classes

  case class Person(name:String, age:Int)
  val bob = Person("BOB", 20)

  val greeting = bob match  {

    case Person(n, a) if a < 21  => s"Hi, my name is $n and I am $a years old and I can't drink in the US" // there is if guard
    case _ => "I don't know who I am "
  }

  println(greeting)

  /*
   case are matched in order
   2. what if no cases are matched
  3. what if no cases are matched it will return a match error
  4. type of the PM expression? unified type of all the types in all the cases
  5. Pattern matching really works well with case classes


   */
  // PM on sealed hierarchies

  sealed class Animal
  case class Dog(breed:String) extends Animal
  case class Parrot(greeting:String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  animal match  {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
    case _: Animal => println("hello world")
  }

  // match everything

  val isEven = x match  {
    case n if n%2 == 0 => true
    case _ => false
  }

  // Why ?

  val isEvenOrNot = x % 2 == 0

  // Exercise


  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2:Expr) extends Expr

  private val expression1 = Number(12)
  private val expression2 = Number(13)
  val sum = Sum(expression1, expression2)
  val prod = Prod(Sum(expression1, expression2), Sum(expression1, expression2))

  private def evaluateExpression(exp: Expr): Int = {
    val evaluation: Int = exp match {
      case Number(value) => value
      case Sum(e1, e2) => evaluateExpression(e1) + evaluateExpression(e2)
      case Prod(e1, e2) => evaluateExpression(e1) * evaluateExpression(e2)
      case _ => 0
    }
    evaluation
  }

  def getResults(value: Int): String = {
    val result = value match {
      case 0 => "No such expression exists"
      case _ => s"The result is $value"
    }
    result

  }

  val value = evaluateExpression(sum)
  val value2 = evaluateExpression(prod)
  println(value2)
  println(getResults(value))
  println(getResults(value2))

  }

