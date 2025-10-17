package model.core.exception;

public class BrukerRepositoryException extends RuntimeException{
    public BrukerRepositoryException(String message){
        super(message);
    }
    public BrukerRepositoryException(String message, Throwable cause){
        super(message, cause);
    }
}
