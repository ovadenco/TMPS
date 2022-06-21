package domain.factory

import domain.factory.abstractions.IBookFactory
import domain.models.SimpleBook

object TechBookFactory : IBookFactory {

    override fun createBook(id: Int): SimpleBook {
        val builder = when (id) {
            1 -> SimpleBook.Builder()
                .setTitle("Kotlin in Action")
                .setAuthor("Dmitry Jemerov, Svetlana Isakova")
                .setLanguage("English")
                .setYear(2017)
                .setPrice(39.99)
            2 -> SimpleBook.Builder()
                .setTitle("Design Patterns: Elements of Reusable Object-Oriented Software")
                .setAuthor("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides")
                .setLanguage("English")
                .setYear(1994)
                .setPrice(20.99)
            else -> throw IllegalArgumentException("there's no book with id $id")
        }
        return builder.setGenre(SimpleBook.Genre.Tech).build()
    }
}