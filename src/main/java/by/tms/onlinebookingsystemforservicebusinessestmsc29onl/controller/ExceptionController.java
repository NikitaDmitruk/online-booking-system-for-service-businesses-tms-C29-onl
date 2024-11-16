package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import javax.management.ServiceNotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Problem.valueOf(Status.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Problem> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Problem.valueOf(Status.BAD_REQUEST, "Нарушение целостности или уникальности данных."));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Problem> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Problem.valueOf(Status.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<Problem> handleAppointmentNotFoundException(AppointmentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Problem.valueOf(Status.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Problem> handleProjectNotFoundException(ProjectNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Problem.valueOf(Status.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(CustomerServiceNotFoundException.class)
    public ResponseEntity<Problem> handleCustomerServiceNotFoundException(CustomerServiceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Problem.valueOf(Status.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Problem> handleRoleNotFoundException(RoleNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Problem.valueOf(Status.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<Problem> handleServiceNotFoundException(ServiceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Problem.valueOf(Status.NOT_FOUND, e.getMessage()));
    }
}
