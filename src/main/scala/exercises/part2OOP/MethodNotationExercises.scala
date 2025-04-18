package exercises.part2OOP

object MethodNotationExercises extends App {
  /*
   1. Overload the + operator
   mary + "the rockstar" => new person "Mary(the rockstar)"
   */

  /*
   2. Add an age to the Person class
   Add a unary + operator => new person with age + 1
   + mary => mary with teh age incrementor
   */

  /*
   3.Add a "learns" method in the Person class
   which receives a string parameter and returns => "Mary learns Scala"
   Use it in postfix notation
   */

  /*
  4. Overload the apply method to receive a number
  and return a string
  mary.apply(2) => "Mary watched Inception 2 times"
   */

  class Person(val name: String, favouriteMovie: String, age: Option[Int] = None) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // Overloaded method which returns another person with nickname
    def +(nickName: String): Person = new Person(s"${this.name}($nickName)", s"${this.favouriteMovie}")

    def unary_+ : Person = new Person(this.name, this.favouriteMovie, this.age.map { x => x + 1 })

    def learns(subject: String): String = s"${this.name} learns $subject."

    def unary_! : String = s"Hello world"

    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is $name and I like $favouriteMovie"

    def apply(number:Int): String = s"${this.name} watched ${this.favouriteMovie} $number times."


  }

  val mary = new Person("Mary", "Avatar", Some(16))

  println((mary + "The emperor")())

  println(mary learns("Java"))

  println((+ mary)())

  println(mary(2))


}
