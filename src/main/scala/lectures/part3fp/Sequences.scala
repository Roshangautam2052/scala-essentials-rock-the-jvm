package lectures.part3fp

import scala.util.Random

object Sequences extends App{

  // Sequences
  /*
    A very general interface for data structures that
    have a well defined order
    can be indexed
   */

  /*
    Supports various operations:
    apply, iterator, length, reverse for indexing and iterating
    concatenation, appending, prepending
    a lot of other: grouping, sorting, zipping, searching, slicing
   */

  val aSequence = Seq(1, 2, 3,4, 100, 12)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(1,2,3,45,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange:Seq[Int] = 1 until 10
  aRange.foreach(println)

  // if we want something to repeat for 10 times we can simply say
  (1 to 10 ).foreach(x => println("Hello"))

  // Lists

  /*
   A LinearSeq immutable linked list
    head, tail, isEmpty methods are fast: O(1)
    most operations are O(n): length, reverse

  Sealed has two subtypes:
  Object Nil(Empty)
  class ::
   */


  // lists

  val alist = List(1,2,3)
  val prepend = 42 :: alist
  val append =  alist :+ 12
  println(prepend)
  println(append)

  val apples5 = List.fill(5)("Apple") // This is a curried function which creates a list of 5 Apples

  println(alist.mkString("-|-"))

  // Arrays

  /*
    The equivalent of simple Java arrays
  can be manually constructed with predefined lengths
  can be mutated(updated in place)
  are interoperable with Java's T[] arrays
  indexing is fast

  Where's the Seq ?!*
   */

  // arrays

  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  println(threeElements)
  threeElements.foreach(println)

  // It can be mutated in place
  numbers(2) = 0 // syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  // arrays and sequences

  val numbersSeq:Seq[Int] = numbers // implicit conversion to array
  println(numbersSeq)

  // Vectors
  /*
   A default implementation for immutable sequences
  effectively constant indexed read and write: O(log32(n))
  fast element addition: append/prepend
  implemented as a fixed-branched trie(branch factor 32)
  good performance for large sizes
   */

  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  val maxRuns = 1000
  val maxCapacity = 100000000

  def getWriteTime(collection:Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0/maxRuns
  }
  // keeps reference to tail
  // updating an element in the middle takes long
  val numbersList = (1 to maxCapacity).toList

  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
