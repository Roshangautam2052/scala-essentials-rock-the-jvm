package lectures.part3fp.otherSocialNetwork

import scala.collection.immutable.List

object NetworkTesting extends App {

  val binita = Person("Binita")
  val aakriti = Person("Aakriti")
  val sabita = Person("Sabita")
  val lolita = Person("Lolita")
  val garima = Person("Garima")
  val puja = Person("Puja")
  val mina = Person("Mina")
  val sarala = Person("Sarala")


  val nepalNetwork = Network(List(
    Map(binita -> List(aakriti, sabita, lolita)),
    Map(aakriti -> List(garima, puja, sarala, lolita, sabita)),
    Map(garima -> List( puja, mina, sarala)),
  ))
  // Adding a person to a network on
  println("---------------Adding Sabita to Garima's Network----------------")
  val newNepalNetwork = nepalNetwork.addPerson(garima, sabita)
  println(newNepalNetwork)

  // Removing a person from someone's network
  println("------------- After removing Sabita from Garima's network---------------")
  val updatedNetworkAfterRemovingPerson = newNepalNetwork.removePerson(garima, sabita)
  println(updatedNetworkAfterRemovingPerson)

  println("---------------- Finding the number of friends in someone's network")

  val aakritisFriendCount = nepalNetwork.getFriendsCount(puja)
  println(aakritisFriendCount)

  println(nepalNetwork.getPersonWithMaximumFriend.map{
    value => value.name
  })

}
