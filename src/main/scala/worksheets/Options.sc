import worksheets.Options.Connection
//Scala Option[T] is a container for zero or one element of a given type.
// An Option[T] can be either Some[T] or None object, which represents a missing value used to avoid null pointer

// Some should always have a valid value inside
val option1: Option[String] = Some("Hello")
val option2: Option[String] = None

// unsafe api method calls
def unsafeMethod(): String = null
def backUpMethod(): String = "Valid Result"

// apply method of companion class of Option will take care of building Some or None according to the value
val result = Option(unsafeMethod())

// chained methods
val chainedResult = Option(unsafeMethod()).orElse(Option(backUpMethod()))

// applying map, flatmap, filter
val mapped = option1.map(x => x.concat(" Jarvis"))
val flatmapped = option1.flatMap(x => Option(x.concat(" Jarvis")))
val filterd = option1.filter(x => x.length > 16)

// EXAMPLE
// Config File
val config: Map[String, String] = Map("host" -> "192.1.1.0", "port" -> "80")
val config2: Map[String, String] = Map()


// HOW TO IMPLEMENT INITIATE_CONNECTION
def initiateConnection(config: Map[String, String]): Unit = {
  // get return Option
  val host = config.get("host")
  val port = config.get("port")

  // returns a Option of Connection
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  if(connection.isEmpty) println("NOT-CONNECTED")
  else println("CONNECTED")

}
initiateConnection(config)
initiateConnection(config2)

//chained calls
def initiateConnection2(config: Map[String, String]): Unit = {
  val status = config.get("host").flatMap(h => config.get("port").flatMap(p => Connection(h, p))).isEmpty
  if(status) println("NOT-CONNECTED")
  else println("CONNECTED")
}
initiateConnection2(config)
initiateConnection2(config2)
