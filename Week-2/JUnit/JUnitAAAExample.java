import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 1. Production Class
class BankAccount {
  private double balance;

  public void deposit(double amount) {
    this.balance += amount;
  }

  public double getBalance() {
    return balance;
  }
}

// 2. Test Class
public class JUnitAAAExample {

  private BankAccount account;

  // Setup Method
  @BeforeEach
  void setUp() {
    account = new BankAccount();
  }

  // Teardown Method
  @AfterEach
  void tearDown() {
    account = null;
  }

  @Test
  void testDepositUsingAAAPattern() {
    // 1. ARRANGE: Set up the specific test data and initial state
    double initialDeposit = 100.0;
    double expectedBalance = 100.0;

    // 2. ACT: Execute the specific method being tested
    account.deposit(initialDeposit);

    // 3. ASSERT: Verify the outcome matches expectations
    assertEquals(expectedBalance, account.getBalance(), "Balance should equal the deposited amount");
  }
}