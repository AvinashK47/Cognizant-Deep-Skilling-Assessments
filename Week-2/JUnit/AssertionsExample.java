// 1. Production Class handling mock authentication checks
class UserService {
  public boolean isValidUsername(String username) {
    if (username == null)
      return false;
    // Username must be alphanumeric and between 5-15 characters
    return username.matches("^[a-zA-Z0-9]{5,15}$");
  }

  public String generateSessionToken(String username, boolean rememberMe) {
    if (username == null || !isValidUsername(username)) {
      return null; // Invalid user gets no token
    }
    return "TOKEN_" + username.toUpperCase() + "_" + (rememberMe ? "LONG" : "SHORT");
  }
}

// 2. Test Class handling various structural assertions
public class AssertionsExample {

  // Custom structural assertions to match JUnit styles
  private static void assertTrue(boolean condition, String msg) {
    if (!condition)
      throw new AssertionError("FAIL: " + msg + " (Expected TRUE)");
    System.out.println("PASS: " + msg);
  }

  private static void assertFalse(boolean condition, String msg) {
    if (condition)
      throw new AssertionError("FAIL: " + msg + " (Expected FALSE)");
    System.out.println("PASS: " + msg);
  }

  private static void assertNull(Object obj, String msg) {
    if (obj != null)
      throw new AssertionError("FAIL: " + msg + " (Expected NULL)");
    System.out.println("PASS: " + msg);
  }

  private static void assertNotNull(Object obj, String msg) {
    if (obj == null)
      throw new AssertionError("FAIL: " + msg + " (Expected NOT NULL)");
    System.out.println("PASS: " + msg);
  }

  public static void main(String[] args) {
    UserService service = new UserService();

    System.out.println("--- Running Assertions Test Suite ---");

    try {
      // Testing assertTrue & assertFalse
      assertTrue(service.isValidUsername("developer1"), "Valid alphanumeric username check");
      assertFalse(service.isValidUsername("usr"), "Username too short check");
      assertFalse(service.isValidUsername("user!name"), "Username containing special chars check");

      // Testing assertNotNull & assertNull
      String validToken = service.generateSessionToken("developer1", true);
      assertNotNull(validToken, "Token should be generated for a valid user");

      String invalidToken = service.generateSessionToken("usr", false);
      assertNull(invalidToken, "Token should be null for an invalid user configuration");

      System.out.println("\nALL ASSERTION TESTS PASSED SUCCESSFULLY!");
    } catch (AssertionError e) {
      System.err.println("\nTEST SUITE FAILED!");
      System.err.println(e.getMessage());
    }
  }
}