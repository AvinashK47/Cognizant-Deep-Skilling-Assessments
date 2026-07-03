// 1. Define the production class containing business logic
class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }
}

// 2. The Test Class acting as the entry point
public class BasicUnitTestExample {

  // Simple custom assertion helper to mimic JUnit's assertEquals
  private static void assertEquals(int expected, int actual, String testName) {
    if (expected == actual) {
      System.out.println("PASS: " + testName);
    } else {
      throw new AssertionError("FAIL: " + testName + " | Expected: " + expected + " but got: " + actual);
    }
  }

  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    System.out.println("--- Running Basic Unit Tests ---");

    // Step 3: Execute tests and verify assertions
    try {
      assertEquals(5, calculator.add(2, 3), "testAdd_PositiveNumbers");
      assertEquals(-1, calculator.add(-2, 1), "testAdd_NegativeNumbers");
      assertEquals(2, calculator.subtract(5, 3), "testSubtract_PositiveNumbers");
      assertEquals(-5, calculator.subtract(-2, 3), "testSubtract_NegativeNumbers");

      System.out.println("\nALL TESTS PASSED SUCCESSFULLY!");
    } catch (AssertionError e) {
      System.err.println("\nTEST SUITE FAILED!");
      System.err.println(e.getMessage());
    }
  }
} 