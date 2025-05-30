package lectures.part3fp.otherSocialNetwork

case class Network(network: List[Map[Person, List[Person]]]) {

  def addPerson(profile: Person, newFriendName: Person): Network = {
    val updatedProfilesNetwork = network.map { profileMap =>
      if (profileMap.contains(profile)) {
        val updatedNetwork = profileMap.updated(
          profile,
          newFriendName :: profileMap(profile)
        )
        println(s"$newFriendName added successfully")
        updatedNetwork
      } else {
        profileMap
      }

    }
    Network(updatedProfilesNetwork)
  }

  def removePerson(profile: Person, removingFriendName: Person): Network = {
    val updatedProfilesNetwork = network.map { profileMap =>
      if (profileMap.contains(profile)) {
        val updatedNetwork = profileMap.updated(
          profile,
          profileMap(profile).filter(_ != removingFriendName)
        )
        updatedNetwork
      } else {
        profileMap
      }
    }
    Network(updatedProfilesNetwork)


  }

  def getFriendsCount(profile: Person): String = {
    val mayBeFriendList = network.collectFirst {
      case map if map.contains(profile) => map(profile)
    }

    mayBeFriendList match {
      case Some(friends) => friends.size.toString
      case None => "No such profile found"
    }

  }
  
  def getPersonWithMaximumFriend:Option[Person]= {
    val mergedMap = network.flatten.toMap
    mergedMap.maxByOption {
      case(_, friends) => friends.size}.map(_._1)
    }
  }

