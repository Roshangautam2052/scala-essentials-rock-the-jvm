package exercises.part1basics

import scala.annotation.tailrec

object FibonacciCalculator extends App {

  private def calculateFibonacciNumber(number: BigInt): BigInt = {
    def fibonacciCalculator(updatedNumber: BigInt): BigInt = {
      if (updatedNumber <= 1) 1
      else {
        fibonacciCalculator(updatedNumber-1) + fibonacciCalculator(updatedNumber-2)
      }


    }
    fibonacciCalculator(number)
  }

  println(calculateFibonacciNumber(12))

}


