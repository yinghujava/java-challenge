package jp.co.axa.apidemo.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Error : The employee id '" + id + "' does not exist.");
    }
}
