package lectures.part2OOP

object AbstractDataTypes extends App {

  // abstract class => which provides boilerplate
  // this cannot be instantiated and are meant to extend later

  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  class Dog extends Animal {

    // the override keyword are not mandatory
    override val creatureType: String = "Caninne"

    def eat: Unit = println("crunch crunch")
  }

  // traits

  trait Herbivores {
    val name:String

    def eat:String = s"grass"
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {

    override val creatureType: String = "croc"

    def eat: Unit = println("nomom nom nom ")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }


  val dog = new Dog

  val croc = new Crocodile

  croc.eat(dog)

  // trait vs abstract classes

  /*
   abstract class can have both abstract and non-abstract members
  traits can also have both abstract and non-abstract members
  traits do not have constructor parameters
   multiple traits may be instantiated by the same class
  traits = describes type of behaviours, abstract class = type of thing"
   */


}
