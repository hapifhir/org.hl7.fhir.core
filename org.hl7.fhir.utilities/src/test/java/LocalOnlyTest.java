import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

public class LocalOnlyTest {

  // Checks if there's an environmental variable called Agent.Id
  @Test
  @DisabledIfEnvironmentVariable(named = "SYSTEM_JOBID", matches = "^(?!\\s*$).+")
  public void onlyRunsOnLocalMachine() {
    System.out.println("Local test has been run.");
  }
}
