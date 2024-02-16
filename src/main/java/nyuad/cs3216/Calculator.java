package nyuad.cs3216;

import nyuad.cs3216.exceptions.DivideByZeroException;

public class Calculator {
   private double currentValue;

   public double divide(int a, int b) throws DivideByZeroException {

      if (b == 0) throw new DivideByZeroException("Cannot divide by zero");

      double result = (double) a / (double) b;
      currentValue = result;
      return result;
   }

   public double getCurrentValue() {
      return currentValue;
   }
}
