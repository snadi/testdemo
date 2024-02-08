package nyuad.cs3216.exceptions;


public class DivideByZeroException extends Exception{
    
    public DivideByZeroException(String errorMessage) {
        super(errorMessage);
    }
}