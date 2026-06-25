import java.util.Arrays;
import java.util.Comparator;

// 1. Setup: Creating the Product class
class Product {
  int productId;
  String productName;
  String category;

  public Product(int productId, String productName, String category) {
    this.productId = productId;
    this.productName = productName;
    this.category = category;
  }

  @Override
  public String toString() {
    return "{ID: " + productId + ", Name: '" + productName + "', Category: '" + category + "'}";
  }
}

// 2. Implementation: The Main Class
public class EcommerceSearchExample {

  // Linear Search Implementation
  // Iterates through every element sequentially until a match is found.
  public static Product linearSearch(Product[] products, int targetId) {
    for (Product p : products) {
      if (p.productId == targetId) {
        return p;
      }
    }
    return null; // Not found
  }

  // Binary Search Implementation
  // Requires a sorted array. Divides the search space in half each iteration.
  public static Product binarySearch(Product[] products, int targetId) {
    int left = 0;
    int right = products.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevents integer overflow

      if (products[mid].productId == targetId) {
        return products[mid];
      } else if (products[mid].productId < targetId) {
        left = mid + 1; // Target is in the right half
      } else {
        right = mid - 1; // Target is in the left half
      }
    }
    return null; // Not found
  }

  public static void main(String[] args) {
    // Initialize an unsorted array of products
    Product[] inventory = {
        new Product(105, "Mechanical Keyboard", "Accessories"),
        new Product(101, "Wireless Mouse", "Accessories"),
        new Product(109, "USB-C Hub", "Electronics"),
        new Product(103, "4K Monitor", "Electronics"),
        new Product(107, "Noise Cancelling Headphones", "Audio")
    };

    System.out.println("--- Linear Search (Unsorted Data) ---");
    Product foundLinear = linearSearch(inventory, 103);
    System.out.println("Search for ID 103: " + (foundLinear != null ? foundLinear : "Not Found"));

    System.out.println("\n--- Binary Search (Sorted Data) ---");
    // Binary search strictly requires the data to be sorted first
    Arrays.sort(inventory, Comparator.comparingInt(p -> p.productId));

    Product foundBinary = binarySearch(inventory, 107);
    System.out.println("Search for ID 107: " + (foundBinary != null ? foundBinary : "Not Found"));
  }
}