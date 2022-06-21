package domain.factory

import domain.factory.abstractions.IBookFactory
import domain.models.Book

object TechBookFactory : IBookFactory {

    override fun createBook(id: Int): Book {
        val builder = when (id) {
            1 -> Book.Builder()
                .setTitle("Kotlin in Action")
                .setAuthor("Dmitry Jemerov, Svetlana Isakova")
                .setLanguage("En")
                .setYear(2017)
            2 -> Book.Builder()
                .setTitle("Design Patterns: Elements of Reusable Object-Oriented Software")
                .setAuthor("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides")
                .setLanguage("En")
                .setYear(1994)
            else -> throw IllegalArgumentException("there's no book with id $id")
        }
        return builder.setGenre(Book.Genre.Tech).build()
    }
}