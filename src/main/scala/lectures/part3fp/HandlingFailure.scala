package lectures.part3fp

import lectures.part3fp.HandlingFailure.HttpService.getConnection

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)


  def unsafeMethod(): String = throw new RuntimeException("No String for you Buster")

  // try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax suger use in practice

  val anotherPotentialFailure = Try {
    // code that might throw an exception


  }
  // utilities

  println(potentialFailure.isSuccess)

  def backupMethod():String = " A valid result "

  val fallBackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallBackTry)

  //IF you design the API

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException())
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap and filter

  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success( x * 10)))
  println(aSuccess.filter(_ > 10))

  // => for -comprehensions

  /*
   Exercise
   */
  println("************** Host Connection ****************")
  val hostName = "localhost"

  val port = "8080"

  def renderHtml(page:String): Unit = println(page)

  class Connection {
    def get(url:String): String = {
      val random = new Random(System.nanoTime)
      if(random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url:String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host:String, port:String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }
    def getSafeConnection(host:String, port:String): Try[Connection] = Try(getConnection(host, port))
  }

  // if we get the HTML page from the connection print it to the console  ie call renderHTML


  val connection = Try {
    HttpService.getConnection(hostName, port)
  }
  val possibleHtml = connection.flatMap(connection  => connection.getSafe("/home"))

  possibleHtml.foreach(renderHtml)

  // shortHand version

  HttpService.getSafeConnection(hostName, port)
    .flatMap(connection  => connection.getSafe("/home"))
    .foreach(renderHtml)

  // for comprehension version
  for {
    connection <- HttpService.getSafeConnection(hostName, port)
    html <- connection.getSafe("/home")
  }renderHtml(html)

}
