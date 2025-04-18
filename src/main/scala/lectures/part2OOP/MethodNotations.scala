package lectures.part2OOP

object MethodNotations extends App{

  class Person(val name:String, favouriteMovie:String) {

    def likes(movie:String):Boolean = movie == favouriteMovie
    def  +(person:Person):String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"Hello world"
    def isAlive:Boolean = true

    def apply():String = s"Hi my name is $name and I like $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // The above two statements are equal
  // infix notation = operator notation (is only valid for method with only one line Syntactic Sugar)

  // "operators" in scala
  val tom = new Person("tom", "fight club")
  println(mary  +  tom)
  println(mary.+(tom))

  println( 1 + 2)
  println(1.+(2)) // The mathematical operators act similar like methods

  // The mathematical operators are acting as similar like methods
   // All operators are methods

   // Akka actors have operators like ! ?

   // prefix notation is about unary operators(where the unary methods are also operators)

   val x = -1
   val y = 1.unary_-
   println(!mary) // This is equivalent to mary.unary_!

   // unary_prefix only works with these operators such as - + ~ !

   // postfix operation)(The function that does not receive any parameters are called post fix notation)

   println(mary.isAlive)


  // apply a special method

  println(mary.apply())
  println(mary()) // equivalent to above whenever a compiler sees an object called like a function then it looks for apply method in that particular class definition

}
