package IntLinkedList

trait IntLinkedListTrait{

  def getHeadValue : Int
  def getTail : IntLinkedListTrait
  def isEmpty : Boolean
  def add(element : Int) : IntLinkedListTrait
  def printElements :String
  override def toString :String = "[" + printElements + "]"

  def filter(predicateFunction : Int => Boolean) : IntLinkedListTrait
  def map(transformFunction : Int => Int) : IntLinkedListTrait
  def flatMap(transformFunction : Int => Int) : IntLinkedListTrait
  def zipWith(list2 : IntLinkedListTrait, zipperFunction : (Int, Int) => Int):IntLinkedListTrait
}
