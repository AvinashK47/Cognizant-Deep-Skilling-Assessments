class Logger {
  private static volatile Logger instance;

  private Logger() {
  }

  public static Logger getInstance() {
    if (instance == null) {
      synchronized (Logger.class) {
        if (instance == null) {
          instance = new Logger();
        }
      }
    }
    return instance;
  }

  public void log(String message) {
    System.out.println("[LOG]: " + message);
  }
}

public class SingletonPatternExample {
  public static void main(String[] args) {

    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();

    logger1.log("Application started. Testing singleton...");

    if (logger1 == logger2) {
      System.out.println("SUCCESS: Only one instance of Logger is created and used across the application.");
    } else {
      System.out.println("FAILURE: Multiple instances detected.");
    }
  }
}