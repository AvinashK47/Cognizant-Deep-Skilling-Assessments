import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

// 1. Production Class
class ShoppingCart {
  private List<String> items = new ArrayList<>();

  public void addItem(String item) {
    items.add(item);
  }

  public int getItemCount() {
    return items.size();
  }

  public void clear() {
    items.clear();
  }
}

// 2. Test Class with Lifecycle Annotations
public class LifecycleAnnotationsExample {

  private ShoppingCart cart;

  // Runs BEFORE every single test
  @BeforeEach
  void setUp() {
    System.out.println("-> @BeforeEach: Initializing a fresh ShoppingCart...");
    cart = new ShoppingCart();
  }

  // Runs AFTER every single test
  @AfterEach
  void tearDown() {
    System.out.println("-> @AfterEach: Cleaning up resources...\n");
    cart.clear();
    cart = null; // Freeing memory
  }

  // Test 1
  @Test
  void testAddItem() {
    System.out.println("Executing testAddItem...");
    cart.addItem("Mechanical Keyboard");
    assertEquals(1, cart.getItemCount(), "Cart should contain 1 item");
  }

  // Test 2
  @Test
  void testEmptyCart() {
    System.out.println("Executing testEmptyCart...");
    // This test gets a BRAND NEW cart because of @BeforeEach,
    // completely unaffected by testAddItem()
    assertEquals(0, cart.getItemCount(), "Fresh cart should be empty");
  }
}