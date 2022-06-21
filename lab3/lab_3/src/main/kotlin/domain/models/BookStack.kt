package domain.models

import domain.models.abstractions.IBook

class BookStack : IBook {
    private val mStack: MutableList<IBook> = ArrayList()

    override fun getInitialPrice(): Double {
        var price = 0.0
        for (item in mStack) {
            price += item.getInitialPrice()
        }
        return price
    }

    override fun getCurrentPrice(): Double {
        var price = 0.0
        for (item in mStack) {
            price += item.getCurrentPrice()
        }
        return price
    }

    override fun getDescription(): String {
        var description = ""
        for (item in mStack) {
            description += "${item.getDescription()}\n"
        }
        return description
    }

    override fun getName(): String {
        var bookNames = ""
        for (item in mStack) {
            bookNames += "${item.getName()}\n"
        }
        return bookNames
    }

    override fun toString(): String {
        var string = ""
        for (item in mStack) {
            string += "${item}\n"
        }
        return string
    }

    fun add(item: IBook) {
        mStack.add(item)
    }

    fun remove(item: IBook): Boolean {
        return mStack.remove(item)
    }

    fun get(i: Int): IBook {
        return mStack[i]
    }
}