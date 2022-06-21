package domain.factory.abstractions

import domain.models.SimpleBook

interface IBookFactory {
    fun createBook(id: Int): SimpleBook
}