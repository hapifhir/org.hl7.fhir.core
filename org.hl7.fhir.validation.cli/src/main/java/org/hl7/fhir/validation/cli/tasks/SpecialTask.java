package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.special.R4R5MapTester;
import org.slf4j.Logger;

@Slf4j
public class SpecialTask extends StandaloneTask{
  @Override
  public String getName() {
    return "special";
  }

  @Override
  public String getDisplayName() {
    return "Special";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return Params.hasParam(args, Params.SPECIAL);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    String specialMode = Params.getParam(args, Params.SPECIAL);
    if ("r4r5tests".equals(specialMode)) {
      final String target = Params.getParam(args, Params.TARGET);
      final String source = Params.getParam(args, Params.SOURCE);
      final String filter = Params.getParam(args, Params.FILTER);
      if (ManagedFileAccess.file(target).exists()) {
        new R4R5MapTester().testMaps(target, source, filter);
      }
    } else {
      log.error("Unknown SpecialMode "+specialMode);
    }
  }
}
