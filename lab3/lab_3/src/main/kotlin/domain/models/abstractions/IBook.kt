package domain.models.abstractions;

public interface IBook {
    fun getInitialPrice(): Double
    fun getCurrentPrice(): Double
    fun getDescription(): String
    fun getName(): String
}
