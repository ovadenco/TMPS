package client

import domain.BookSeller


fun main(args: Array<String>) {
    BookSeller.initialize()
    for (i in 0..2) {
        BookSeller.sellBooks()
    }

}
