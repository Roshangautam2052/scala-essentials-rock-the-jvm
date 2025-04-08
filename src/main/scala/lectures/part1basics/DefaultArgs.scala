package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)


  val fact10 = trFact(10, 2)

  /*
  99% of time we call a function with the same params
   Here in this case we can say that the default value of acc can be made to 1 just buy doing this
  as the accumulator can pollute the function signature
   N.B in the above function if acc = 1 has been set as default we can also
   override it by passing another value as 2 in the trFact(10, 2) in this case 2 will be overridden.
   */


  def savePicture(format: String, width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")

  savePicture("jpeg")

  /* In order to use the default argument we can do the following
   1. pass in every leading argument
  2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "png")
}
