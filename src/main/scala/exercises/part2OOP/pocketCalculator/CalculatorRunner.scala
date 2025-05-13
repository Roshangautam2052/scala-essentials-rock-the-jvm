package exercises.part2OOP.pocketCalculator

import exercises.part2OOP.pocketCalculator.exception.{MathCalculationException, OverFlowException, UnderFlowException}

object CalculatorRunner extends App {

  class RunCalculator {
    private val mathCalculator = new MathCalculator

    def add(x: Int, y: Int): Unit = {
      try {
        println(mathCalculator.add(x, y))
      }
      catch {
        case e: OverFlowException => println(e.message)
      }
    }

    def subtract(x: Int, y: Int): Unit = {
      try {
        println(mathCalculator.subtract(x, y))
      } catch {
        case e: UnderFlowException => println(e.message)
      }
    }

    def multiply(x: Int, y: Int): Unit = {
      try {
        println(mathCalculator.multiply(x, y))
      } catch {
        case e: UnderFlowException => println(e.message)
        case e: OverFlowException => println(e.message)
      }
    }

    def divide(x: Int, y: Int): Unit = {
      try {
        println(mathCalculator.divide(x, y))
      } catch {
        case e: MathCalculationException => println(e.message)
      }
    }
  }

  private val runCalculatorInstance = new RunCalculator
  println(runCalculatorInstance.divide(12, 0))
  println(runCalculatorInstance.add(12, 2147483647))
  println(runCalculatorInstance.subtract(12, 2147483647))
  println(runCalculatorInstance.multiply(12, 2147483647))


}
