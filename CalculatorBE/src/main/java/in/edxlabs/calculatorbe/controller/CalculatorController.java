package in.edxlabs.calculatorbe.controller;

import in.edxlabs.calculatorbe.dto.CalculationRequest;
import in.edxlabs.calculatorbe.dto.CalculationResponse;
import in.edxlabs.calculatorbe.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public CalculationResponse calculate(
            @Valid @RequestBody CalculationRequest request) {

        double result = calculatorService.calculate(request);

        return new CalculationResponse(result);
    }
}