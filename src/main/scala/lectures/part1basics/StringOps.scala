package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning scala"

  println(str.charAt(2)) // returns the character at that index

  println(str.substring(7, 11)) // index 7 inclusive and 11 excluding

  println(str.split(" ").toList) // this will create a list of string by splitting with spaces

  println(str.replace(" ", "_"))

  println(str.toLowerCase())

  println(str.length)

  val aNumberString = "45"

  val aNumber = aNumberString.toInt

  // prepending operations and appending operations are scala specific
  println('a' +: aNumberString :+ 'z')

  println(str.reverse)

  println(str.take(2))

  // Scala-specific:String interpolators.

  //S- interpolators

  val name = "David"

  val age = 12

  val greeting = s"Hello, my name is $name and I am $age years old"

  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."

  println(anotherGreeting)

  // F-interpolates


  val speed = 1.2f

  val myth = f"$name can eat $speed%2.2f burgers per minute"

  println(myth)
}
