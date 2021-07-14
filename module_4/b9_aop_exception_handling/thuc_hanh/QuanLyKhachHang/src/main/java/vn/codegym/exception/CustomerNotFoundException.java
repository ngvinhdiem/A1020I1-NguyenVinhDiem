package vn.codegym.exception;

public class CustomerNotFoundException extends Exception{

    public String getMessage(){
        return "Error not found Customer";
    }
}
