package exercises.part1basics

/**
 * Create a function which prints a name  and age in the format 
 * Hi my name is $name, and I am $age years old.
 */
object GreetingFunction extends App {

  def greetingFunction(name: String, age: String): String = s"Hi my name is $name, and I am $age years old."
    
  println(greetingFunction("Sabita", "12"))
}
