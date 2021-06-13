package model;

public class Calculator {
    private double firstNum;
    private double secondNum;
    private String operator;

    public Calculator(double firstNum, double secondNum, String operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double result(){
        double result = 0;
        switch (this.operator){
            case "Addition(+)":
                result = this.firstNum + this.secondNum;
                break;
            case "Subtraction(-)":
                result = this.firstNum - this.secondNum;
                break;
            case "Multiplication(x)":
                result = this.firstNum * this.secondNum;
                break;
            case "Division(/)":
                result = this.firstNum / this.secondNum;
                break;
            default:
                result = 0;
        }
        return result;
    }
}