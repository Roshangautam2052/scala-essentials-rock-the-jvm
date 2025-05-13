package exercises.part2OOP.pocketCalculator

import exercises.part2OOP.pocketCalculator.exception.{MathCalculationException, OverFlowException, UnderFlowException}

class MathCalculator extends AbstractCalculator {

  override def add(x: Int, y: Int): Int =
    val result = x + y
    if (result > Int.MaxValue || result < 0) throw OverFlowException()
    else result

  override def subtract(x: Int, y: Int): Int = {
    val result = x - y
    if (result > Int.MinValue) throw UnderFlowException()
    else result
  }

  override def multiply(x: Int, y: Int): Int = {
    val result = x * y
    result match {
      case value if value > Int.MaxValue => throw OverFlowException()
      case value if value < Int.MinValue => throw UnderFlowException()
      case _ => result
    }
  }

  override def divide(dividend: Int, divisor: Int): Int = {
    divisor match {
      case value if (value == 0) => throw MathCalculationException()
      case _ => dividend / divisor
    }
  }
}
