package exercises.part2OOP
/**
 * Novel and Writer
 * Writer: first name, surname, year
 * --method to give fullname
 *
 * Novel:name, year of release, author
 * --authorAge
 * -isWrittenBy(author)
 * --copy (new year of release) = new instance of Novel
 */
object NovelAndWriter extends App{

  val writer1 = new Writer("Roshan", "Gautam", "25")

  val lifeOfHimalaya = new Novel("Life in Himalaya", "2028", writer1)

  println(lifeOfHimalaya.authorAge)

  println(lifeOfHimalaya.isWrittenBy)

  private val updatedLifeOfHimalaya = lifeOfHimalaya.copy("2027")

  println(updatedLifeOfHimalaya.toString)
}

class Writer(val firstName:String, val surName:String, val year:String) {

  def getFullName:String = s"The fullName of the author is $firstName $surName"
}

class Novel(name:String, yearOfRelease:String, author:Writer) {
  def authorAge :String = author.year

  def isWrittenBy:String = author.getFullName

  def copy(newReleaseYear:String):Novel = new Novel(name, newReleaseYear, author)
}