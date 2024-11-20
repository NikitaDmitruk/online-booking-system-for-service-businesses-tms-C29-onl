package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class UserNotFoundException extends AbstractThrowableProblem {

    public UserNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "User not found");
    }
}
