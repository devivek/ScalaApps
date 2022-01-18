package IntLinkedList

class IntLinkedList (private val head : Int, private val tail : IntLinkedListTrait) extends IntLinkedListTrait {

  override def getHeadValue: Int = head
  override def getTail: IntLinkedListTrait = tail
  override def isEmpty: Boolean = false
  override def add (element: Int): IntLinkedListTrait = new IntLinkedList(element, this)
  override def printElements: String =
    if(tail.isEmpty) head.toString
    else head + " -> " + tail.printElements

  override def filter(predicateFunction: Int => Boolean): IntLinkedListTrait =
    if(predicateFunction(head)) new IntLinkedList(head, tail.filter(predicateFunction))
    else tail.filter(predicateFunction)

  override def map(transformFunction: Int => Int): IntLinkedListTrait =
    new IntLinkedList(transformFunction(head), tail.map(transformFunction))

  override def flatMap(transformFunction: Int => Int): IntLinkedListTrait =
    new IntLinkedList(head, new IntLinkedList(transformFunction(head), tail.flatMap(transformFunction)))

  override def zipWith(list2: IntLinkedListTrait, zipperFunction: (Int, Int) => Int): IntLinkedListTrait =
    if(list2.isEmpty) throw new RuntimeException("List provided doesn't has the same length upon which zipperFunction is applied")
    else new IntLinkedList(zipperFunction(head, list2.getHeadValue), tail.zipWith(list2.getTail, zipperFunction))
}
