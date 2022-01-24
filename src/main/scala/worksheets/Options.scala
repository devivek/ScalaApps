package worksheets

import scala.util.Random

//Scala Option[T] is a container for zero or one element of a given type.
// An Option[T] can be either Some[T] or None object, which represents a missing value used to avoid null pointer

object Options extends App {
  // Connection class
  class Connection {
    def connect = "CONNECTED"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None

    }
  }
}
