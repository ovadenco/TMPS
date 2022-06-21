package domain

interface PhrasesSet {
    fun sayHello(seller: BookSeller)
    fun sayGoodbye(seller: BookSeller)

    class Morning : PhrasesSet {
        override fun sayHello(seller: BookSeller) {
            println("Good morning!")
        }

        override fun sayGoodbye(seller: BookSeller) {
            println("Have a nice day!")
            seller.setPhrasesSet(Afternoon())
        }

    }

    class Afternoon : PhrasesSet {
        override fun sayHello(seller: BookSeller) {
            println("Good afternoon! Welcome to our book store.")
        }

        override fun sayGoodbye(seller: BookSeller) {
            println("Thanks for the purchase!")
            seller.setPhrasesSet(Evening())
        }

    }

    class Evening : PhrasesSet {
        override fun sayHello(seller: BookSeller) {
            println("Good evening!")
        }

        override fun sayGoodbye(seller: BookSeller) {
            println("Bye!")
            seller.setPhrasesSet(Morning())
        }

    }
}