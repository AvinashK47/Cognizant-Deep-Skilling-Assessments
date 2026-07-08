import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// 1. Production Interface (The external dependency)
interface ExternalApi {
  String getData();
}

// 2. Production Service (The class we are actually testing)
class MyService {
  private ExternalApi api;

  // Dependency Injection via constructor
  public MyService(ExternalApi api) {
    this.api = api;
  }

  public String fetchData() {
    return api.getData();
  }
}

// 3. The Test Class covering both Mockito exercises
public class MockitoExercisesExample {

  // --- Exercise 1: Mocking and Stubbing ---
  @Test
  public void testExternalApi() {
    // 1. Create a mock object for the external API
    ExternalApi mockApi = Mockito.mock(ExternalApi.class);

    // 2. Stub the methods to return predefined values
    when(mockApi.getData()).thenReturn("Mock Data");

    // Inject the mock into the service
    MyService service = new MyService(mockApi);

    // 3. Write a test case that uses the mock object
    String result = service.fetchData();
    assertEquals("Mock Data", result, "Service should return the stubbed mock data");
  }

  // --- Exercise 2: Verifying Interactions ---
  @Test
  public void testVerifyInteraction() {
    // 1. Create a mock object
    ExternalApi mockApi = Mockito.mock(ExternalApi.class);
    MyService service = new MyService(mockApi);

    // 2. Call the method with specific arguments
    service.fetchData();

    // 3. Verify the interaction
    // This ensures that service.fetchData() actually executed mockApi.getData()
    // internally
    verify(mockApi).getData();
  }
}