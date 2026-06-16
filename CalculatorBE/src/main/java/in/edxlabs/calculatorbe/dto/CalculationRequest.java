package in.edxlabs.calculatorbe.dto;

import in.edxlabs.calculatorbe.enums.Operation;
import jakarta.validation.constraints.NotNull;

public record CalculationRequest(

        @NotNull(message = "Operand 1 is required")
        Double operand1,

        @NotNull(message = "Operand 2 is required")
        Double operand2,

        @NotNull(message = "Operation is required")
        Operation operation

) {
}