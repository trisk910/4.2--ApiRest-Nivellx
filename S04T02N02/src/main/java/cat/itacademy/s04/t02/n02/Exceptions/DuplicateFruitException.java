package cat.itacademy.s04.t02.n02.Exceptions;

public class DuplicateFruitException extends RuntimeException {
    public DuplicateFruitException(String message) {
        super(message);
    }
}