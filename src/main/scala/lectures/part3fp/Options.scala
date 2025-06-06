package lectures.part3fp

import scala.util.Random

object Options extends App{

  val myFirstOption:Option[Int] = Some(4)
  val noOption:Option[Int] = None

  println(myFirstOption)

  // This is how we work with Unsafe APIs
  // It was used to deal with unsafe APIs

  def unsafeMethod():String = null

  val result = Some(unsafeMethod()) // This is wrong as Some always needs to have a valid value

  val result2 = Option(unsafeMethod()) // This will build Some or None based on this method

  println(result)

  // chained methods

  def backupMethod():String = "A valid result "

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod():Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // Functions on Options

  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // This is Unsafe --> we should not use this

  // map, flatMap, filter

  println(myFirstOption.map(_* 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))


  // for-comprehensions

  /**
   * Exercise
   *
   */
  val config:Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected " // connected to some server

  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host:String, port:String):Option[Connection] = {
      if(random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // try to establish a connection, if we can't establish the connection print the connect method

  val host = config.get("host")
  val port = config.get("port")
  // if *h != null ) and if (p != null ) return Connection.apply(h, p) return null
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  // if(c != null) return c.connect return null
  val connectionStatus = connection.map(c => c.connect)
 /// if (status ! = null) println(status)
  println(connectionStatus.foreach(println))


}
