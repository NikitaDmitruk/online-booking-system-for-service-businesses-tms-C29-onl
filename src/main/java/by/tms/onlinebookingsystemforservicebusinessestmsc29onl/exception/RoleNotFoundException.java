package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class RoleNotFoundException extends AbstractThrowableProblem {

    public RoleNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Role not found");
    }
}
