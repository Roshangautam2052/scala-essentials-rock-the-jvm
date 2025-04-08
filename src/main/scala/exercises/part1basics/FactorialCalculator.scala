package exercises.part1basics

import scala.annotation.tailrec

object FactorialCalculator extends App{

  private def calculateFactorial(n:BigInt):BigInt = {
    @tailrec
    def factorialCalculator(acc:BigInt, updatedNumber:BigInt):BigInt = {
      if(updatedNumber == 1) acc
      else
        factorialCalculator(acc * updatedNumber, updatedNumber-1)
    }
    factorialCalculator(1, n)
  }


  println(calculateFactorial(20))

}
