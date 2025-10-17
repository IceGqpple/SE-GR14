package model.core.exception;

public class ReiseRepositoryException extends RuntimeException {

    public ReiseRepositoryException(String message) {
        super(message);
    }
    public ReiseRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }


}
