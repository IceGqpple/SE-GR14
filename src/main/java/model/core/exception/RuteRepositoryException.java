package model.core.exception;

public class RuteRepositoryException extends RuntimeException{
    public RuteRepositoryException(String message) {
        super(message);
    }
    public RuteRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
