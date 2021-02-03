package b8_clean_code_refactoring.thuchanh;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Calculator {

    public static int calculate(int firstOperand, int secondOperator, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperator;
            case '-':
                return firstOperand - secondOperator;
            case '*':
                return firstOperand * secondOperator;
            case '/':
                if (secondOperator != 0)
                    return firstOperand / secondOperator;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}


class CalculatorTest {

    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        char operator = '+';
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        char operator= '-';
        int expected = 1;

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        char operator = '*';
        int expected = 4;

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        char operator = '/';
        int expected = 2;

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operator = '/';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, operator);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operator = '=';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperand, secondOperand, operator);});
    }
}


public class RefactoringDoiTenBienTachHang {
    public static void main(String[] args) {
        Calculator firstCalc = new Calculator();
        System.out.println(firstCalc.calculate(11,3,'+'));
    }
}
