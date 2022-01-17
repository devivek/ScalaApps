package GenericLinkedList

object EmptyLinkedList extends LinkedListTrait[Nothing] {

  override def getHeadValue: Nothing = throw new NoSuchElementException
  override def getTail: LinkedList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing] (element: B): LinkedListTrait[B] = new LinkedList (element, EmptyLinkedList)
  override def printElements: String = ""
}
