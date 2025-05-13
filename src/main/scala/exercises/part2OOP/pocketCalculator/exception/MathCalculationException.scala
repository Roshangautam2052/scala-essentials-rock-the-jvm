package exercises.part2OOP.pocketCalculator.exception

case class MathCalculationException(message:String = "Division by zero is not possible") extends Exception {
}
