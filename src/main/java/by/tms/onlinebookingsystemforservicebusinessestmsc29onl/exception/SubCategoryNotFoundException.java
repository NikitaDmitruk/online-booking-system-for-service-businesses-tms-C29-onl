package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class SubCategoryNotFoundException extends AbstractThrowableProblem {

    public SubCategoryNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Sub-Category Not Found");
    }
}
