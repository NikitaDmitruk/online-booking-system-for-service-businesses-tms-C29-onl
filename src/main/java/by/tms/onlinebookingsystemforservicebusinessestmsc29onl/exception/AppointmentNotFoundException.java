package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException() {
        super();
    }

    public AppointmentNotFoundException(String message) {
        super(message);
    }

    public AppointmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppointmentNotFoundException(Throwable cause) {
        super(cause);
    }
}
