package domain.factory

import domain.factory.abstractions.IBookFactory
import domain.models.SimpleBook

object FictionBookFactory : IBookFactory {

    override fun createBook(id: Int): SimpleBook {
        val builder = when (id) {
            1 -> SimpleBook.Builder()
                .setTitle("Fahrenheit 451")
                .setAuthor("Ray Bradbury")
                .setLanguage("English")
                .setYear(1953)
                .setPrice(12.99)
            2 -> SimpleBook.Builder()
                .setTitle("Crime and Punishment")
                .setAuthor("Fyodor Dostoyevsky")
                .setLanguage("Russian")
                .setYear(1866)
                .setPrice(15.49)
            else -> throw IllegalArgumentException("there's no book with id $id")
        }
        return builder.setGenre(SimpleBook.Genre.Fiction).build()
    }
}