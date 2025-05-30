package exercises.part3fp
/*
  What would happen if I had two original entries"Jim" -> 555 and "JIM" -> 900
 */

object TuplesAndMapExercises extends App{
  val firstMap = Map("Jim" -> 2555, "JIM" -> 900).withDefaultValue("There is no such element")
  

  //println(firstMap.map(pair => pair._1.toLowerCase -> pair._2))
  println(firstMap.map(pair => pair._1.toLowerCase -> pair._2))

}
