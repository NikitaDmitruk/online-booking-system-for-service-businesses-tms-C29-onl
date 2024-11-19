package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class AppointmentNotFoundException extends AbstractThrowableProblem {

    public AppointmentNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Appointment not found");
    }
}
