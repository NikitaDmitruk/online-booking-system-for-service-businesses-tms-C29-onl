package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class ServiceCategoryNotFoundException extends AbstractThrowableProblem {

    public ServiceCategoryNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Service category not found");
    }
}
