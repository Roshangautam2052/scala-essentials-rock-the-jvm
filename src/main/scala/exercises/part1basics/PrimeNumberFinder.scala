package exercises.part1basics

import scala.annotation.tailrec

object PrimeNumberFinder extends App {

  def evaluatePrimeNumber(n: Int): Boolean = {
    @tailrec
    def findPrimeNumber(count: Int, updatedNumber: Int): Boolean = {
      if (updatedNumber < 1) {
        if (count <= 2)  true
        else false
      }
      else {
        if ((n % updatedNumber) == 0) findPrimeNumber(count + 1, updatedNumber - 1)
        else findPrimeNumber(count, updatedNumber - 1)
      }
    }
    findPrimeNumber(0, n)
  }

  println(evaluatePrimeNumber(5))
}
