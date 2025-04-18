package exercises.part2OOP

/**
 * Counter class
 * -- receives an int value
 * -- method current count
 * -- method to increment/decrement => new Counter
 * -- overload inc/dec to receive an amount
 */
object CounterClass extends App {

  val counter1 = new Counter(12)

  println(counter1.currentCount)
  println(counter1.increment)
  println(counter1.decrement)
  println(counter1.increment(14))
  println(counter1.decrement(14))
}

class Counter(val input: Int) {

  def currentCount: Int = input

  def increment: Counter =
    println("Incrementing")
    new Counter(input + 1)// whenever we need a new value we need to give a new instance of the class due to immutability

  def decrement: Counter =
    println("decrementing")
    new Counter(input -1)

  def increment(amount: Int): Counter = {
    if(amount <= 0) this
    else increment.increment(amount -1 )
  }

  def decrement(amount: Int): Counter = {
    if(amount <= 0) this
    else decrement.decrement(amount - 1)
  }
}
