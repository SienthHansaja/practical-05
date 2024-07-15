object Fibonacci {
  def fib(n: Int): Int = {
    if (n <= 1) n
    else fib(n - 1) + fib(n - 2)
  }

  def main(args: Array[String]): Unit = {
    print("Enter the number of terms: ")
    val numTerms = scala.io.StdIn.readInt()

    println("Fibonacci series:")
    for (i <- 0 until numTerms) {
      print(fib(i) + " ")
    }
    println() // Add a newline at the end
  }
}
