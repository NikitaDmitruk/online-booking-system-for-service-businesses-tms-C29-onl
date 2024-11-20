package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class ScheduleNotFoundException extends AbstractThrowableProblem {

    public ScheduleNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Schedule not found");
    }
}
