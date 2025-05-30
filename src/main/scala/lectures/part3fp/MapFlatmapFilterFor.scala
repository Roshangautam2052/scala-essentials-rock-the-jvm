package lectures.part3fp

object MapFlatmapFilterFor extends App{

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))

  println(list.map(_ + "is a number"))

  // filter

  println(list.filter(_ %2 == 0))

  val toPair = (x:Int) => List(x, x +1)
  println(list.flatMap(toPair))

  // print all the combinations between two lists

  val numbers = List(1, 3, 4, 5)
  val number2 = List(0, 12, 13, 14)
  val chars = List('a', 'b', 'c', 'd')

  def combinationCreator = (a:List[Int], b:List[Char]) => {
    val resultMap = a.flatMap { value  =>
      b.map { other =>
        (value, other)
      }
    }
    resultMap
  }
  println(combinationCreator(numbers, chars))

   // Iterations
  def flatMapCombinationCreator = (a:List[Int], b:List[Char]) => {
    a.flatMap(n => b.map(c => "" + c + n))
  }

  println(flatMapCombinationCreator(numbers, chars))

  // foreach is used if the result type is unit
  list.foreach(println)

  val listNumbers = List(1, 2, 3, 4, 5)
  val listColours = List("green", "yellow", "blue")
  val listCharacters = List('a', 'b','c')

  val combinationOfNumbersColoursAndCharacters =  {
    listNumbers.flatMap {
      x => listColours .flatMap{
        y => listCharacters.map { value  =>
          "" + x + y + "_" + value
        }
      }
    }
  }
  println(combinationOfNumbersColoursAndCharacters)

  val combinationsOfAll = for {
    x <- listNumbers
    y <- listColours
    z <- listCharacters
  } yield "" + x + y + "_" + z

  println(combinationsOfAll)
  
}
