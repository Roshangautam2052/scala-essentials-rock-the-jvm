package exercises.part2OOP

object Generics extends App{

  class MyList[+A] {
    // use the type A
    
    // Covariant Type A occurs in contravariant Type A position in Type A of value element
    //def add(element:A): MyList[A] = ???

    def add[B >:A](element:B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  // objects cannot be type parameterized

  object MyList {
      def empty[A]: MyList[A] = ???

  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal

  class Cat extends Animal
  // Does list of Cat also extends list of Animal

  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList:CovariantList[Animal] = new CovariantList[Cat]
  // can we do animalList.add(new Dog) ???? // Hard questions // The solution is we return a list of Animal


  // 2. No = INVARIANCE
  class InvariantList[A]

  val invariantAnimalList:InvariantList[Animal] = new InvariantList[Animal]

  // Hell, No ! Contravariant

  class Trainer[-A]
  val trainer:Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // They allow us to use generic classes only for certain types that are sub class of different type or super class of different type
   // this is upper bounded type
  // A <:Animal means that the type A is subtype of Animal
  // A >:Animal means that A is super Type of Animal
  
  class Cage[A <:Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car

  // val newCage = new Cage(new Car)  this is invalid as car is not a subtype of Animal
  // bounded type solves the covariance problem
}
