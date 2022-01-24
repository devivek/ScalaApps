// FlatMaps
/* Inner grouping of an item is removed and a sequence is generated
Blend of map method and flatten method */
// flattening returns a single collection of elements by merging child collections
val fruits = Seq("apple", "banana", "orange")
// MAPPING -> List("APPLE", ...) -> Flattening
fruits.flatMap(_.toUpperCase)

val list1 = List(1, 2, 3, 4, 88)
val list2 = List("a", "b", "c")

// get list of combination string
val combinations = list1.flatMap(x => list2.map(y => s"$x/$y"))
//get list of list
val listOfList = list1.map(x => list2.map(y => s"$x/$y"))

// for-comprehensions
val forComprehension = for {
  x <- list1
  y <- list2
} yield s"$x/$y"

// reduce - using a binary operation to produce a single value
list1.reduce((a, b) => a max b)

// Finding Avg using map and reduce
val seq = List(5, 6, 99, 2)
val c1 = seq.map(x => (x, 1))
val (total, num) = c1.reduce((p1, p2) => (p1._1 + p2._1, p1._2 + p2._2))
println(total / num)

// fold - Like reduce fold also takes a binary operation -> single value
// fold allows us to define an initial value
val emptySeq:Seq[Int] = Seq()
val seq:Seq[Int] = Seq(1,6,7)
emptySeq.fold(0)((a,b) => a+b)
seq.fold(1)((a,b) => a*b)

// Scan function takes the binary operation as parameter and
// returns the value for each element in collection for that operation
seq.scan(1)((a,b) => a*b)

// ZIP
val result = list1.zip(list2)
val (unzippedList1, unzippedList2) = result.unzip

// will throw a error if not matched
val head :: tail = list1

//Exercise -  Use FlatMap to apply filter operation
def predicate(x :Int ) = x % 2 == 0
list1.flatMap(x => if(predicate(x)) List(x) else Nil)
