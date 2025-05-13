package lectures.part2OOP

import lectures.part2OOP.Enums.Permissions.READ

object Enums extends App {
  
  enum Permissions  {
    case READ, WRITE, EXECUTE, NONE // this is sealed type
    
    // add fields/ methods
    def openDocument(): Unit =
      if(this == READ) println("opening document....")
      else println("reading not allowed")
  }
  
  val somePermissions: Permissions = Permissions.READ
  
  // we can also create a companion object of an Enum 
  
  // we can also see the index of the field which was defined in the enum 
  
  // we can also iterate more the enums using .values method 
  // val readPermission:Permissions = Permissions.valueOf("READ") // this string will be parsed and will be one of the value in the enums 

}
