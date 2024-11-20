package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

@ControllerAdvice
public class SecurityExceptionHandler implements ProblemHandling, SecurityAdviceTrait {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Problem> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        Problem problem = Problem.builder()
                .withTitle("Violation of an integrity constraint")
                .withStatus(Status.CONFLICT)
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }

}
