package lectures.part4

object BracelessSyntax extends App{

  // if - expressions

  val anIfExpression = if (2 >3) "bigger" else "smaller"

  // java -style
  val anIfExpression_V2 = {
    if(2 >3) {
      "bigger"
    }else {
      "smaller"
    }


    // compact
    val anIfExpression_v3 =
      if( 2 > 3) "bigger"
      else "smaller"
  }

  // scala 3

  val anIfExpression_V4 =
    if 2 > 3 then
      "bigger"
    else
      "smaller"

  val anIfExpression_v5 =
    if 2 > 3 then
      val result = "bigger"
        result
    else
      val result = "smaller"
      result


}
