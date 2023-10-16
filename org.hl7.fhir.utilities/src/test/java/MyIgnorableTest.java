
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

public class MyIgnorableTest {

  @Test
  @Tag("excludedInSurefire")
  public void testMe() {
    System.out.println("You have tested me.");
  }
}

