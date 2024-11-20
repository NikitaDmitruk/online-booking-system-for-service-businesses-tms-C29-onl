package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class UsernameAlreadyExistsException extends AbstractThrowableProblem {

    public UsernameAlreadyExistsException() {
        super(null, "Already exists", Status.CONFLICT, "Username already exists");
    }
}
