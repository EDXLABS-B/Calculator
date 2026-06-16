package in.edxlabs.calculatorbe.service;

import in.edxlabs.calculatorbe.dto.CalculationRequest;
import in.edxlabs.calculatorbe.exception.InvalidCalculationException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(CalculationRequest request) {

        double operand1 = request.operand1();
        double operand2 = request.operand2();

        return switch (request.operation()) {

            case ADD -> operand1 + operand2;

            case SUBTRACT -> operand1 - operand2;

            case MULTIPLY -> operand1 * operand2;

            case DIVIDE -> {
                if (operand2 == 0) {
                    throw new InvalidCalculationException(
                            "Division by zero is not allowed"
                    );
                }

                yield operand1 / operand2;
            }
        };
    }
}