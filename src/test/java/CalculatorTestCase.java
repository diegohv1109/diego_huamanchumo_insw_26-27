import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import com.uem.Calculator;

public class CalculatorTestCase {
    public Calculator calculator;

   @BeforeEach 
   
   public void setUp() {
      calculator = new Calculator();
   }
   
   @Test 
   public void multiplyTest() {
     assertEquals(6, calculator.multiply(2, 3));
   }
   
   @Test 
   public void concatTest() {
     assertEquals("HolaMundo!", calculator.concat("Hola", "Mundo!"));
   }

   @Test
   public void sumTest() {
      assertEquals(8.40, calculator.sum(2.20, 6.20));
   }

   @Test
   public void discountTest() {
      assertEquals(30, calculator.discount(60, 50));
   }

   @Test
   public void calculateTotalTest() {
      assertEquals(1000.00, calculator.calculateTotal(List.of(200.00, 300.50, 249.50, 50.00, 200.00)));
   }
}
