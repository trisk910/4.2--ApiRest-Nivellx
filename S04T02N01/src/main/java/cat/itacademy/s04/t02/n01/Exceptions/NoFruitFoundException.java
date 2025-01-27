package cat.itacademy.s04.t02.n01.Exceptions;

public class NoFruitFoundException extends RuntimeException {
    public NoFruitFoundException(String message) {
        super(message);
    }
}