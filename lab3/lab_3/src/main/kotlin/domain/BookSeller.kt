package domain

import domain.factory.FictionBookFactory
import domain.factory.TechBookFactory
import domain.models.BookStack
import domain.models.DiscountedBook
import domain.models.abstractions.IBook
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import kotlin.system.exitProcess

object BookSeller {
    private val mAllBooks: BookStack = BookStack()
    private var mPhrasesSet: PhrasesSet = PhrasesSet.Morning()

    fun initialize() {
        mAllBooks.add(TechBookFactory.createBook(1))
        mAllBooks.add(TechBookFactory.createBook(2))
        mAllBooks.add(FictionBookFactory.createBook(1))
        mAllBooks.add(FictionBookFactory.createBook(2))
    }

    fun listBooks() {
        println("Here are the books we have:\n${mAllBooks.getName()}")
    }

    fun sellBooks() {
        mPhrasesSet.sayHello(this)
        val scanner = Scanner(System.`in`)
        lateinit var chosenBook: IBook
        while (true) {
            println("\nWhich book are you interested in?\n(enter 0 for all books or 1-4 for a specific book)")
            chosenBook = when (val a = scanner.nextInt()) {
                0 -> mAllBooks
                in 1..4 -> mAllBooks.get(a - 1)
                else -> throw IllegalArgumentException("wrong input")
            }
            println(chosenBook.getDescription())

            println("Do you want to proceed to proceed to checkout? (y/n)")
            if ("y" in scanner.next()) break
        }

        println("Do you have a discount card? (y/n)")
        if ("y" in scanner.next()) {
            chosenBook = DiscountedBook(chosenBook)
        }

        println("Ok. It will cost $${chosenBook.getCurrentPrice().limitDecimalPlaces(2)}\n")

        mPhrasesSet.sayGoodbye(this)
    }

    fun setPhrasesSet(phrases: PhrasesSet) {
        mPhrasesSet = phrases
        println("\n\n------------------------------- it's ${ when(phrases) {
            is PhrasesSet.Afternoon -> "2 p.m."
            is PhrasesSet.Evening -> "7 p.m."
            else -> "9 a.m."
        } } -------------------------------\n")
    }


    private fun Double.limitDecimalPlaces(decimalPlaces: Int): Double {
        return BigDecimal(this).setScale(decimalPlaces, RoundingMode.FLOOR).toDouble()
    }

}