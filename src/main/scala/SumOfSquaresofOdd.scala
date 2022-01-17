/*The program is to find the sum of square of the odd numbers in a list passed and print the sum in the console*/
object SumOfSquaresOfOdd
{
  def main(args:Array[String]):Unit =
  {
    val initialList = List(1,2,3,4,5,6,7,8,9)
    def sumOfSquaresofOdd = initialList.filter(x => x % 2 == 1).map(x => x * x).reduce((x,y) => x+y)
    println(sumOfSquaresofOdd)
  }
}
