import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
