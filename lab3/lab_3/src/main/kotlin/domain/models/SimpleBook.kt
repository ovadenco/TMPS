package domain.models

import domain.models.abstractions.IBook

class SimpleBook(
    private val author: String,
    private val title: String,
    private val year: Int,
    private val language: String,
    private val genre: Genre,
    private val price: Double
    ): IBook {

    override fun getInitialPrice(): Double = price

    override fun getCurrentPrice(): Double = price

    override fun toString(): String {
        return "Book {\n  genre = $genre \n  autor = $author \n  title = $title\n  year = $year \n  language = $language\n}"
    }

    override fun getDescription(): String {
        val genreString = when (genre) {
            Genre.Tech -> " tech"
            Genre.Fiction -> " fiction"
            else -> ""
        }
        return "$title is a$genreString book by $author. It was written in $language in $year."
    }

    override fun getName(): String = "$title ($author)"


    private constructor(builder: Builder) : this(builder.author, builder.title,  builder.year, builder.language, builder.genre, builder.price)

    class Builder {
        var author: String = "Unknown author"
            private set
        var title: String = "No information about title"
            private set
        var year: Int = 0
            private set
        var language: String = "No information about language"
            private set
        var genre: Genre = Genre.Unknown
            private set
        var price: Double = 0.0
            private set


        fun setAuthor(author: String) = apply { this.author = author }

        fun setTitle(title: String) = apply { this.title = title }

        fun setYear(year: Int) = apply { this.year = year }

        fun setLanguage(language: String) = apply { this.language = language }

        fun setGenre(genre: Genre) = apply { this.genre = genre }

        fun setPrice(price: Double) = apply { this.price = price }

        fun build() = SimpleBook(this)
    }

    enum class Genre {
        Unknown,
        Tech,
        Fiction,
    }
}