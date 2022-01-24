import GenericLinkedList._
import IntLinkedList._

object MyApp extends App{

  var list = new LinkedList(3,new LinkedList(6, new LinkedList(1, EmptyLinkedList)))
  var list2 = new LinkedList("Hello",new LinkedList("Hello2", new LinkedList("Hello3", EmptyLinkedList)))
  println(list2.toString)
  //ISSUE - 1
  //var i : LinkedList[String] = EmptyLinkedList
  //var j : LinkedList[Int] = EmptyLinkedList

  var intLinkedList = new IntLinkedList(1, new IntLinkedList(2, new IntLinkedList(3, new IntLinkedList(10, EmptyIntLinkedList))))
  var intLinkedList2 = new IntLinkedList(0, new IntLinkedList(8, new IntLinkedList(9, new IntLinkedList(100, EmptyIntLinkedList))))
  println(intLinkedList.toString)
  println(intLinkedList2.toString)
  def myPredicate(element: Int) : Boolean = {
    if(element % 2 == 0) true
    else false
  }

  var filterd =  intLinkedList.filter(myPredicate)
  var mapped = intLinkedList.map(x => x * x)
  var flatMapped = intLinkedList.flatMap(x => x * x)
  var zipped = intLinkedList.zipWith(intLinkedList2, (x, y) => x + y)
  println("filtered : " + filterd.toString)
  println("mapped : " + mapped.toString)
  println("flatMapped : " + flatMapped.toString)
  println("zipped : " + zipped.toString)



}
