package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class ProjectNotFoundException extends AbstractThrowableProblem {

    public ProjectNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Project not found");
    }
}
