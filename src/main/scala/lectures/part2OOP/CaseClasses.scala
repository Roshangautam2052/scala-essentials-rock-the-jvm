package lectures.part2OOP

object CaseClasses  extends App{
 /*
  Case classes have equals, hasCode, toString method as default
  lightWeight data holding classes
  */

 case class Person(name:String, age:Int)

 // 1. class parameters are fields

 val jim = new Person("Jim", 34)
 println(jim.name)
 println(jim.toString)
 // 2. sensible toString

 // println(instance) = println(instance.toString)

 // 3. equals and hasCode implemented out of the box make it usage for collections

 val jim2 = new Person("Jim", 34)
 println(jim == jim2)

 // case classes have handy copy method

 val jim3 = jim.copy(age = 45)
 println(jim3)

 //5. Case classes have companion object

 val thePerson = Person
 val mary = Person("Mary", 23) // this delegates to apply method we don't use new in case classes

 // 6. Case classes are serializable

 // messages are general in case classes

 // Case classes have extractor patterns = Case classes can be used in Pattern Matching

// Case object are like case classes but they dont get its companion objects like case classes
 case object UnitedKingdom {
  def name:String = "The UK"
 }

}
