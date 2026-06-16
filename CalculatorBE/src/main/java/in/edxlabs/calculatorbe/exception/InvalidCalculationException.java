package in.edxlabs.calculatorbe.exception;

public class InvalidCalculationException extends RuntimeException {

    public InvalidCalculationException(String message) {
        super(message);
    }
}