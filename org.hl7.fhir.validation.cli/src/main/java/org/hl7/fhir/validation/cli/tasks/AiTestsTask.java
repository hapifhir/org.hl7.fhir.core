package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.validation.ai.AITests;
import org.hl7.fhir.validation.cli.param.parsers.AITestsParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import org.hl7.fhir.validation.cli.param.Params;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class AiTestsTask extends StandaloneTask{
  @Override
  public String getName() {
    return "aiTests";
  }

  @Override
  public String getDisplayName() {
    return "AI Tests";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, AITestsParametersParser.AI_TESTS);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(@Nonnull String[] args) throws Exception {
    String source = Params.getParam(args, AITestsParametersParser.SOURCE);
    String config = Params.getParam(args, AITestsParametersParser.CONFIG);
    boolean runTests = Params.hasParam(args, GlobalParametersParser.RUN_TESTS);
    
    AITests ai = new AITests();
    ai.execute(source, config, runTests);
    SystemExitManager.finish();
  }

}
