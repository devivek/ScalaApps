
val tuple1: Tuple2[String, Int] = Tuple2("Hello", 2)
val tuple2: (String, Int) = ("Hello", 2)
val tuple3: (String, Int) = "Hello" -> 2

// Tuples supports PM
val (string, num) = tuple1

val nestedTuple = (1, ("Amar", 59))

val result = nestedTuple match {
  case (4, (b, c)) => "Found1"
  case (1, (b, 0)) => "Found2"
  case (1, (b, 59)) => "Found3"
  case (a, (b, c)) => "Found4"
  case _ => "Default"
}

val phonebook : Map[String, Int] = Map("Vivek" -> 33446667, "Aman" -> 245345, "vaihaw" -> 33444, "Raj" -> 6655, "Kumar" -> 667)
val value = phonebook.get("Vivek")
val value2 = phonebook.get("Vivekfdfdf")
val doesContain = phonebook.contains("Vivek")
val value3 = phonebook + ("Vivek" -> 998)
val value5 = phonebook - "Vivek"
// Map with all name in upper case
phonebook.map(pair => (pair._1.toUpperCase() , pair._2))

// Map whose element start with V
phonebook.filter(pair => pair._1.toUpperCase().startsWith("V"))

val listOfFriends = List("Aman", "Vivek", "Vaihaw", "Nikku", "Mohit", "Paras")
//group them by their length
val groupByNameLength = listOfFriends.groupBy(element => element.length)

//SIMPLE MAP BASED SOCIAL NETWORK
def addPerson(network : Map[String, Set[String]], person : String) : Map[String, Set[String]] =
  network + (person -> Set())

def addFriendship(network : Map[String, Set[String]], person1 : String, person2 :String) : Map[String, Set[String]] = {
  val friend1 = network(person1)
  val friend2 = network(person2)
  network + (person1 -> (friend1 + person2)) + (person2 -> (friend2 + person1))
}
def removeFriendship(network : Map[String, Set[String]], person1 : String, person2 :String) : Map[String, Set[String]] = {
  val friend1 = network(person1)
  val friend2 = network(person2)
  network + (person1 -> (friend1 - person2)) + (person2 -> (friend2 - person1))
}

def removePerson(network : Map[String, Set[String]], person : String) : Map[String, Set[String]] = {
  def removePersonAux(friends : Set[String], networkAccum : Map[String, Set[String]]): Map[String, Set[String]] = {
    if(friends.isEmpty) networkAccum
    else removePersonAux(friends.tail, removeFriendship(networkAccum, person, friends.head))
  }
  val unFriended = removePersonAux(network(person), network)
  unFriended - person
}

val emptyNetwork : Map[String, Set[String]] = Map()
val myNetwork = addPerson(addPerson(emptyNetwork, "Aman"), "Rajesh")
val temp1 = addFriendship(myNetwork, "Aman", "Rajesh")
val temp2 = addPerson(temp1, "Vaihaw")
val temp3 = addFriendship(temp2, "Vaihaw", "Aman")
removePerson(temp3, "Aman")

