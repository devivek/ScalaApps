package GenericLinkedList

class LinkedList [+A] (private val head : A, private val tail : LinkedListTrait[A]) extends LinkedListTrait[A] {

  override def getHeadValue: A = head
  override def getTail: LinkedListTrait[A] = tail
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): LinkedListTrait[B] = new LinkedList(element, this)
  override def printElements: String =
    if(tail.isEmpty) head.toString
    else head + " -> " + tail.printElements

}
