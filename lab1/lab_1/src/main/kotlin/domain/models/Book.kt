package domain.models

class Book(
    val author: String,
    val title: String,
    val year: Int,
    val language: String,
    val genre: Genre,
    ) {

    override fun toString(): String {
        return "Book {\n  genre = $genre \n  autor = $author \n  title = $title\n  year = $year \n  language = $language\n}"
    }

    private constructor(builder: Builder) : this(builder.author, builder.title,  builder.year, builder.language, builder.genre)

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


        fun setAuthor(author: String) = apply { this.author = author }

        fun setTitle(title: String) = apply { this.title = title }

        fun setYear(year: Int) = apply { this.year = year }

        fun setLanguage(language: String) = apply { this.language = language }

        fun setGenre(genre: Genre) = apply { this.genre = genre }

        fun build() = Book(this)
    }

    enum class Genre {
        Unknown,
        Tech,
        Fiction,
    }
}