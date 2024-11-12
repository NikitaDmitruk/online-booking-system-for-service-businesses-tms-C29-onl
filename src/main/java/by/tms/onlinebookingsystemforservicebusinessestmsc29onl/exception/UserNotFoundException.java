package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
