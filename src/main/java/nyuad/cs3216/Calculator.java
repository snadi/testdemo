package nyuad.cs3216;

public class Calculator {
   private double currentValue;

   public double divide(int a, int b) {

      double result = (double) a / (double) b;
      currentValue = result;
      return result;
   }

   public double getCurrentValue() {
      return currentValue;
   }
}
