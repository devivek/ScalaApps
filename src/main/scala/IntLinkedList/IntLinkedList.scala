package IntLinkedList

class IntLinkedList (private val head : Int, private val tail : IntLinkedListTrait) extends IntLinkedListTrait {

  override def getHeadValue: Int = head
  override def getTail: IntLinkedListTrait = tail
  override def isEmpty: Boolean = false
  override def add (element: Int): IntLinkedListTrait = new IntLinkedList(element, this)
  override def printElements: String =
    if(tail.isEmpty) head.toString
    else head + " " + tail.printElements

  override def filter(predicateFunction: Int => Boolean): IntLinkedListTrait =
    if(predicateFunction(head)) new IntLinkedList(head, tail.filter(predicateFunction))
    else tail.filter(predicateFunction)

  override def map(transformFunction: Int => Int): IntLinkedListTrait =
    new IntLinkedList(transformFunction(head), tail.map(transformFunction))
}
