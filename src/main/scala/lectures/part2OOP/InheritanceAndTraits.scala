package lectures.part2OOP

object InheritanceAndTraits extends App {


  class Animal {
    val creatureType:String = "Domestic"
    // Scala offers single class inheritance
   def eat = println("nomomom")
  }

  class Cat extends Animal {
    def crunch = {
      super.eat // this will call the method from the superclass
      println("crunch crunch")
    }
  }

  val cat = new Cat

  cat.crunch

  // constructors

  class Person(name: String, age: Int) {
    // auxiliary constructor
    def this(name:String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog extends Animal{

    override val creatureType = "domestic"

    override def eat: Unit = println("HUH HUH")

  }

  // We can override fields in the superclass directly from the constructor as well
  class Dog1(override val creatureType:String) extends Animal  {

    override def eat = println("Dog1 eating ")
  }

  val dog = new Dog
  println(dog.creatureType)
  println(dog.eat)

  // type substitution (broad: polymorphism)
  val unknownAnimal:Animal = new Dog1("K9")
  println(unknownAnimal.eat)

  // overriding means that using the methods or instance variables from the parent class with new implementation
  // overloading means using the same method name in different areas but with different implementation meaning changing the method signature
  // signature means => method parameters (numbers, types) and return type of the method


  // super calling the methods from the parent class

  // preventing overrides
  // using final keyword
  // 1. using final keyword  on methods
  // 2. using final keyword in class it cannot be extends
  // 3. also using seal means  = extend the class in this file but cannot be extended from another file
  // 4. we used seal types to use it exhaustive (including or considering all elements or aspects)
  // for example if we know that the Cat and Dog are the only animals which we will use in the project then we can seal the abstract class



}

