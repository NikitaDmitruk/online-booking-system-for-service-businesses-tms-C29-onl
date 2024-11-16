package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

public class CustomerServiceNotFoundException extends RuntimeException {
    public CustomerServiceNotFoundException() {
        super();
    }

    public CustomerServiceNotFoundException(String message) {
        super(message);
    }

    public CustomerServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerServiceNotFoundException(Throwable cause) {
        super(cause);
    }
}
