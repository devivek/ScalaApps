package worksheets

object Others extends App {
  // flatmap
  val listOfInt = List(1, 3, 5, 7, 88, 99)
  var list2 = listOfInt.flatMap(x => List(x, s"${x.toString.length}"))

  val setOfInt = Set(1, 3, 5, 88, 99, 7)
  println(setOfInt.head)

  // call by name and call by value
  // call by value - lazy or delayed evaluation of the expression everytime when used
  def fun1(x: => Long): Unit = {
    println(x)
    println(x)
    println(x)
  }
  fun1(System.nanoTime())


}
