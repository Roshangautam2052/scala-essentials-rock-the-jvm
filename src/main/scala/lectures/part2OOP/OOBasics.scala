package lectures.part2OOP

object OOBasics extends App {

  val person = new Person("hari", 12) // Instantiated the class

  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()
  // For every instantiation of a Person class the whole block of code is evaluated
  // this is the keyword used of the
}

// constructor in the class basically says that every instance of person must be constructed by passing in into it
class Person(name: String, val age: Int) {

  // body
  val x = 2 // these are fields

  println(1 + 3)

  def greet(name:String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, I am $name")
  
  // multiple constructors 
  
  /*
   We can create different constructors in a class using this
   */
  // Default parameters also uses  constructors as well  and they are not used as well 
  def this(name:String) = this(name, 0)
  def this() = this("John Doe")
}