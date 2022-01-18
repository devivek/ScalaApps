package IntLinkedList

object EmptyIntLinkedList extends IntLinkedListTrait {

  override def getHeadValue: Int = throw new NoSuchElementException
  override def getTail: IntLinkedListTrait = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add (element: Int): IntLinkedListTrait = new IntLinkedList (element, EmptyIntLinkedList)
  override def printElements: String = ""

  override def filter(predicateFunction: Int => Boolean): IntLinkedListTrait = EmptyIntLinkedList

  override def map(transformFunction: Int => Int): IntLinkedListTrait = EmptyIntLinkedList

  override def flatMap(transformFunction: Int => Int): IntLinkedListTrait = EmptyIntLinkedList

  override def zipWith(list2: IntLinkedListTrait, zipperFunction: (Int, Int) => Int): IntLinkedListTrait = EmptyIntLinkedList
}
