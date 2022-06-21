package client
import domain.factory.FictionBookFactory
import domain.factory.TechBookFactory
import java.lang.IllegalArgumentException
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    print("choose book genre (tech - 1; fiction - 2)\n")
    val bookFactory = when (scanner.nextInt()) {
        1 -> TechBookFactory
        2 -> FictionBookFactory
        else -> throw IllegalArgumentException("wrong input")
    }
    print("choose book id (1 or 2)\n")
    val bookId = scanner.nextInt()
    val book = bookFactory.createBook(bookId)

    println(book.toString())
}
