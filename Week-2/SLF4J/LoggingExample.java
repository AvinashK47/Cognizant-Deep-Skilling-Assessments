import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
  // Initialize the logger for this specific class
  private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

  public static void main(String[] args) {
    System.out.println("--- Starting Logging Execution ---");

    // Simulating a system warning
    logger.warn("This is a warning message: Memory usage is approaching 80%.");

    // Simulating a critical error
    logger.error("This is an error message: Database connection lost!");

    System.out.println("--- Execution Completed ---");
  }
}