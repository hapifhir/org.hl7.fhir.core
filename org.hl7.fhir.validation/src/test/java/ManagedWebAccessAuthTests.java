import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.junit.BeforeClass;

public class ManagedWebAccessAuthTests {
  @BeforeClass
  public static void setUp() {
    ManagedWebAccess.setUserAgent("hapi-fhir-testing-client");
  }
}
