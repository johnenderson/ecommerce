package tech.buildrun.ecommerce.exception;

public class CreateUserException extends RuntimeException {
    public CreateUserException(String message) {
        super(message);
    }
}
