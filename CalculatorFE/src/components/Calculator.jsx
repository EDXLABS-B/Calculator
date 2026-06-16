import { useState } from "react";
import { calculate } from "../service/calculatorApi";
import Result from "./Result";

function Calculator() {
  const [operand1, setOperand1] = useState("");
  const [operand2, setOperand2] = useState("");
  const [operation, setOperation] = useState("ADD");
  const [result, setResult] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleCalculate = async () => {
    setError("");
    setResult(null);

    if (operand1 === "" || operand2 === "") {
      setError("Please enter both numbers");
      return;
    }

    try {
      setLoading(true);

      const response = await calculate({
        operand1: Number(operand1),
        operand2: Number(operand2),
        operation
      });

      setResult(response.result);
    } catch (err) {
  console.log("Error:", err);
  console.log("Response:", err.response);

  setError(
    err.response?.data?.message ||
    JSON.stringify(err.response?.data) ||
    err.message
  );
  } finally {
      setLoading(false);
    }
  };

  return (
    <div className="calculator-container">
      <h1>React + Spring Boot Calculator</h1>

      <input
        type="number"
        placeholder="First number"
        value={operand1}
        onChange={(e) => setOperand1(e.target.value)}
      />

      <select
        value={operation}
        onChange={(e) => setOperation(e.target.value)}
      >
        <option value="ADD">+</option>
        <option value="SUBTRACT">−</option>
        <option value="MULTIPLY">×</option>
        <option value="DIVIDE">÷</option>
      </select>

      <input
        type="number"
        placeholder="Second number"
        value={operand2}
        onChange={(e) => setOperand2(e.target.value)}
      />

      <button onClick={handleCalculate} disabled={loading}>
        {loading ? "Calculating..." : "Calculate"}
      </button>

      {error && <p className="error">{error}</p>}

      {result !== null && <Result result={result} />}
    </div>
  );
}

export default Calculator;