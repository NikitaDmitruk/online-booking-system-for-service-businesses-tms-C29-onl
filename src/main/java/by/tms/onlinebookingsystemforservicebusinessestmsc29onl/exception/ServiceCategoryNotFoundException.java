package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

public class ServiceCategoryNotFoundException extends RuntimeException {
    public ServiceCategoryNotFoundException() {
        super();
    }

    public ServiceCategoryNotFoundException(String message) {
        super(message);
    }

    public ServiceCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceCategoryNotFoundException(Throwable cause) {
        super(cause);
    }
}
