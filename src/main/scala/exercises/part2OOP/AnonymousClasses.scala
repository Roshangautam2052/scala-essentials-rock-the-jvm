package exercises.part2OOP

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }


  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahhahahahhaa")
  }
  /*
   This is what actually happens

  class AnonymousClasses$$annon$1 extends Animal {
     override def eat: Unit = println("ahhhaa")

  val funnyAnimal: Animal = new AnonymousClasses$annon$1
   */

  println(funnyAnimal.eat)

  // anonymous class works for both abstract and non abstract class
  class Person(val name:String) {
    def sayHi: Unit  = println(s"Hi, my name is $name, how can I help you ?")
  }

  val normalPerson = new Person("Madhav") {
    override def sayHi: Unit = println(s"what is your father ${this.name}")

  }


}
