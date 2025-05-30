package lectures.part3fp

object TuplesAndMaps extends App{

  // tuples = finite ordered "lists

  val aTuple = new Tuple2(2, "hello scala") // Tuple2[Int, String] = (Int, String)
  val aTuple2 = Tuple2(2, "hello scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // access first element or other element
  println(aTuple.copy(_2 = "goodBye Java"))
  println(aTuple.swap) // "hello, Scala, 2

  // Maps - keys -> values
  val aMap:Map[String, Int] = Map()

  val phoneBook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue("There is no such element ")


  // a -> b is a syntactic sugar for(a, b)

  // map operations

  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary")) // NoSuch element exception

  // add a pairing

  val newPairing = "Mary" -> 678

  val newPhoneBook = phoneBook + newPairing

  // functionals on maps

  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("J")))


  // mapValues
  println(phoneBook.mapValues(number => "02345" + 10))

  // conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 666)).toMap)
  val names = List("Bob")
}
