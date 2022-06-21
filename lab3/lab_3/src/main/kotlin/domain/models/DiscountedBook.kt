package domain.models

import domain.models.abstractions.IBook

class DiscountedBook(val book: IBook): IBook {

    override fun getInitialPrice(): Double = book.getInitialPrice()

    override fun getCurrentPrice(): Double = book.getInitialPrice()*0.80

    override fun getDescription(): String = book.getDescription()

    override fun getName(): String = book.getName()

    override fun toString(): String = book.toString()

}