package vn.codegym.exception;

public class DuplicateEmailException extends Exception{
    public String getMessage(){
        return "Error email";
    }
}