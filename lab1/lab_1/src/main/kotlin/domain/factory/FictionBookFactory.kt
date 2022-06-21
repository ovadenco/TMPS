package domain.factory

import domain.factory.abstractions.IBookFactory
import domain.models.Book

object FictionBookFactory : IBookFactory {

    override fun createBook(id: Int): Book {
        val builder = when (id) {
            1 -> Book.Builder()
                .setTitle("Fahrenheit 451")
                .setAuthor("Ray Bradbury")
                .setLanguage("En")
                .setYear(1953)
            2 -> Book.Builder()
                .setTitle("Crime and Punishment")
                .setAuthor("Fyodor Dostoyevsky")
                .setLanguage("Ru")
                .setYear(1866)
            else -> throw IllegalArgumentException("there's no book with id $id")
        }
        return builder.setGenre(Book.Genre.Fiction).build()
    }
}