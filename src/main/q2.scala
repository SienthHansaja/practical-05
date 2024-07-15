case class Book(title: String, author: String, isbn: String)

object Library {
  var books: Set[Book] = Set(
    Book("Sherlock Holmes", "Authar C. Doil", "663573"),
    Book("Kali Yugaya", "Martin Wikramasinghe", "334853"),
    Book("Baddegama", "A.P Gunarathne", "338493")
  )

  def printBook(): Un it = {
    books.foreach(book =>
      println(
        s"${book.title} by ${book.author} (ISBN: ${book.isbn})"
      )
    )
  }

  def addBook(book: Book): Unit = {
    books = books + book
  }
  def removeBook(isbn: String): Unit = {
    books = books.filterNot(_.isbn == isbn)
  }

  def searchByAuthor(author: String): Unit = {
    val foundBooks = books.filter(_.author == author)
    if (foundBooks.isEmpty) {
      println(s"No books found by author '$author'")
    } else {
      foundBooks.foreach(book =>
        println(s"Found: ${book.title} by ${book.author} (ISBN: ${book.isbn})")
      )
    }
  }

  def checkbook(isbn: String): Unit = {
    if (books.exists(_.isbn == isbn)) {
      println(s"Book Found with the ISBN $isbn")
    } else
      println("Book Not Found!")
  }

  def searchBook(title: String): Unit = {
    books.find(_.title == title) match {
      case Some(book) =>
        println(s"Found: ${book.title} by ${book.author} (ISBN: ${book.isbn})")
      case None => println(s"Book with title '$title' not found")
    }
  }

  def main(args: Array[String]): Unit = {
    println("----------Book Store----------")
    Library.printBook()

    println("\n--Adding a new book--\n")
    Library.addBook(Book("The Famous Five", "F. Scott Fitzgerald", "978052"))
    Library.printBook()
    println("\n--Removing a book--\n")
    Library.removeBook("334853")
    Library.printBook()

    println("\nEnter the ISBN to check the book")
    val isbn = scala.io.StdIn.readLine()
    Library.checkbook(isbn)

    println("Enter the title to check the book")
    val title = scala.io.StdIn.readLine()
    Library.searchBook(title)

    println("Enter the author to check the books")
    val author = scala.io.StdIn.readLine()
    Library.searchByAuthor(author)

  }
}
