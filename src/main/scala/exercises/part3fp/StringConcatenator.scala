package exercises.part3fp
/*
 String concatenation function
 */
object StringConcatenator extends App {

  val stringConcatenation: (String, String) => String = new Function2[String, String, String] {
    override def apply(value1: String, value2:String) =  value1+ value2
  }

  println(stringConcatenation("Roshan ", "Garima"))
  
  // Anonymous function way of creating stringConcatenation 
  
   val stringConcatenation2:(String, String) => String = _ + _
  
  val stringConcatenation6: (String,String) => String = (a:String, b:String) => a + b
  
  val adder: (Int, Int) => Int = (a:Int, b:Int) => a + b

}
