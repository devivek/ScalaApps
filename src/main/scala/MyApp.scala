import GenericLinkedList._
import IntLinkedList._

object MyApp extends App{

  var list = new LinkedList(3,new LinkedList(6, new LinkedList(1, EmptyLinkedList)))
  var list2 = new LinkedList("Hello",new LinkedList("Hello", new LinkedList("Hello", EmptyLinkedList)))
  println(list2.toString)
  //ISSUE - 1
  //var i : LinkedList[String] = EmptyLinkedList
  //var j : LinkedList[Int] = EmptyLinkedList

  var intLinkedList = new IntLinkedList(1, new IntLinkedList(2, new IntLinkedList(3, new IntLinkedList(10, EmptyIntLinkedList))))
  println(intLinkedList.toString)

  def myPredicate(element: Int) : Boolean = {
    if(element % 2 == 0) true
    else false
  }

  var filterd =  intLinkedList.filter(myPredicate)
  var mapped = intLinkedList.map(x => x * x)
  println(filterd.toString)
  println(mapped.toString)

}
