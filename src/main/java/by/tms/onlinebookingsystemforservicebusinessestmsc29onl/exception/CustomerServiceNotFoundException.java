package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class CustomerServiceNotFoundException extends AbstractThrowableProblem {

    public CustomerServiceNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Customer not found");
    }
}
