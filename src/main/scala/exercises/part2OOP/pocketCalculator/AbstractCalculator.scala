package exercises.part2OOP.pocketCalculator

abstract class AbstractCalculator {
  
  def add(x: Int, y: Int): Int 

  def subtract(x: Int, y: Int): Int

  def multiply(x: Int, y: Int): Int

  def divide(x: Int, y: Int): Int
}
