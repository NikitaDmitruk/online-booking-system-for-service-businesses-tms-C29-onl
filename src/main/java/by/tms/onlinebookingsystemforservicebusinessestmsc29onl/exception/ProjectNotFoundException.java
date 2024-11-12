package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

public class ProjectNotFoundException extends Throwable {
    public ProjectNotFoundException() {
        super();
    }

    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectNotFoundException(Throwable cause) {
        super(cause);
    }
}
