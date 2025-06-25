package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ai.AITests;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.cli.param.Params;
import org.slf4j.Logger;

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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return Params.hasParam(args, Params.AI_TESTS);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    String source = Params.getParam(args, Params.SOURCE);
    String config = Params.getParam(args, Params.CONFIG);
    boolean runTests = Params.hasParam(args, Params.RUN_TESTS);
    
    AITests ai = new AITests();
    ai.execute(source, config, runTests);
    SystemExitManager.finish();
  }

}
