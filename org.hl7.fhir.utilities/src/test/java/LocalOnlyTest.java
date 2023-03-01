import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class LocalOnlyTest {

  // Checks if there's an environmental variable called SYSTEM_JOBID with any content. This is a predefined variable for Azure pipeline agents, so this test will not be run on Azure agent builds.
  @Test
  @DisabledIfEnvironmentVariable(named = "SYSTEM_JOBID", matches = "^(?!\\s*$).+")
  public void onlyRunsOnLocalMachine() {
    System.out.println("Local only test has been run.");
  }

  // Checks if there's an environmental variable called SYSTEM_JOBID with any content. This is a predefined variable for Azure pipeline agents, so this test will be run on Azure agent builds and not locally (unless this variable has been set manually).
  @Test
  @EnabledIfEnvironmentVariable(named = "SYSTEM_JOBID", matches = "^(?!\\s*$).+")
  public void onlyRunsOnAzureAgent() {
    System.out.println("Agent only test has been run.");
  }
}
