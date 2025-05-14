package exercises.part3fp
/*
 String concatenation function
 */
object StringConcatenator extends App {

  val stringConcatenation: (String, String) => String = new Function2[String, String, String] {
    override def apply(value1: String, value2:String) =  value1+ value2
  }

  println(stringConcatenation("Roshan ", "Garima"))

}
