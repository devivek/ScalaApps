import scala.util.Random

//parameter as fields
//has equals and hashcode implemented
//Serializable
// has companion objects -> apply method returns the new instance
//CC works well with Pattern Matching
case class Person(name: String, age: Int)
val listOfPersons = List(Person("Vivek", 22), Person("Aman", 23), Person("Vaihaw", 24), Person("Mohit", 29))


//Pattern Matching
// cases are matched sequentially

val randon = new Random()
val x = randon.nextInt(10)

// Using as switch
val desciption = x match {
  case 1 => "One"
  case 2 => "Two"
  case 3 => "Three"
  case 4 => "Four"
  case 5 => "Five"
  case 6 => "Six"
  case _ => "Others"
}
val bob = Person("Bob", 88)

// Decompose values
// note - cover default case otherwise MatchError can be thrown
val greetings = bob match {
  case Person(a, b) if b > 10 => s"Hello, I am $a"
  case _ => "Unknown Value"
}

// PM on List
val any1 : Any = true
val any2 : Any = List(1,2,3,4,5)
val any3 : Any = List(1,2,3,4)
val any4 : Any = Seq()

def extractor(e :Any) = e match {
  case List(1, _, _, _) => "A List with 1 as head and size 4"
  case List(1, _*) => "A List with 1 as head"
  case true => "A true Boolean"
  case Seq(_, _, _, _) => "A Seq of four"
  case Seq() => "A Seq"
  case List() => "A List"
  case _ => "Default"
}
extractor(any1)
extractor(any2)
extractor(any3)
extractor(any4)

// PM - Example
// write a function that takes a Expression and return a human readable string
trait Expression
case class Number(n: Int) extends Expression
case class Sum(e1: Expression, e2: Expression) extends Expression
case class Product(e1: Expression, e2: Expression) extends Expression

def show(expression : Expression) :String = expression match {
  case Number(n) => s"$n"
  case Sum(e1, e2) => show(e1) + " + " + show(e2)
  case Product(e1, e2) => show(e1) + " * " + show(e2)
}

show(Product(Number(5), Number(7)))
show(Sum(Number(5), Number(7)))
show(Sum(Number(5), Product(Number(5), Number(7))))


