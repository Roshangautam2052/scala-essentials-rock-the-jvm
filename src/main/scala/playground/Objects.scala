package playground

object Objects extends App {

  // SCALA does not have a class-level functionality ("static")

  // objects in scala can have something static field using object
  // objects can have vals, methods
  object Person {
    // "static"/"class" -level functionality
    // type + its only instance
    val N_EYES :Int = 2
    def canFly:Boolean = false

    // this from(apply) method is called factory method as its sole purpose is to build a Person
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  // this design pattern is called companion object
  class Person(val name:String) {
    // instance level functionality


  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects are a singleton instance

  val mary = Person
  val john = Person

  val januma = new Person("muna")
  val gariam = new Person("garima")

  println(januma == mary) // this will return false as januma and mary are different instances of Person class

  println(mary == john) // this will return true as the person mary and john instance are same which point to same instance Person as Person is a singleton instance
  // singleton means that only single instance can be referred to object

  // often we have factory methods in singleton objects

  val bobbie = Person.apply(januma, gariam) // we can directly call the apply method in the singleton instance  for creating an instance of bobbie
  val noobie = Person(januma, gariam) // or we can call the Person object like we are creating an instance of a class like by calling constructors


  // Scala applications = Scala objects with
  // def main (args:Array[String]): Unit is converted into Java runnable code
}
