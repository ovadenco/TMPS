package domain.factory.abstractions

import domain.models.Book

interface IBookFactory {
    fun createBook(id: Int): Book
}