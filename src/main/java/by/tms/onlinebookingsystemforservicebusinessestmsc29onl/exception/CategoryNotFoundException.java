package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class CategoryNotFoundException extends AbstractThrowableProblem {

    public CategoryNotFoundException() {
        super(null, "Not found", Status.NOT_FOUND, "Category not found");
    }
}
