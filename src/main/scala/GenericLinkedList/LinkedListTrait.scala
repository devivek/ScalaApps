package GenericLinkedList

trait LinkedListTrait[+A] {

  def getHeadValue : A
  def getTail : LinkedListTrait[A]
  def isEmpty : Boolean
  def add[B >: A](element : B) : LinkedListTrait[B]
  def printElements :String
  override def toString :String = "[" + printElements + "]"

}
