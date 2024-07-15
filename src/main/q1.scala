object q1 {

  def getProdcutList(productList: List[String]): List[String] = {
    println("Enter the product name :")
    val item = scala.io.StdIn.readLine()
    if (item != "done") {
      getProdcutList(productList :+ item)
    } else productList

  }

  def printProductList(finalList: List[String]): Unit = {
    println("\n Product List")
    finalList.foreach(println)
  }

  def getTotalProducts(finalList: List[String]): Int = {
    val noOfProducts = finalList.length
    noOfProducts

  }

  def main(args: Array[String]): Unit = {
    var productList: List[String] = List()
    var finalList = getProdcutList(productList)
    printProductList(finalList)
    var totalProducts = getTotalProducts(finalList)
    println(s"\nNo of products in the list : $totalProducts")
  }

}
