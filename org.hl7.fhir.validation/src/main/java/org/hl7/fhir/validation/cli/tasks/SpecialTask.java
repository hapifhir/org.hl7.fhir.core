package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.utils.Params;
import org.hl7.fhir.validation.special.R4R5MapTester;

import java.io.File;
import java.io.PrintStream;

public class SpecialTask extends StandaloneTask{
  @Override
  public String getName() {
    return "special";
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return Params.hasParam(args, Params.SPECIAL);
  }

  @Override
  public void printHelp(PrintStream out) {

  }

  @Override
  public void executeTask(CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    String specialMode = Params.getParam(args, Params.SPECIAL);
    if ("r4r5tests".equals(specialMode)) {
      final String target = Params.getParam(args, Params.TARGET);
      final String source = Params.getParam(args, Params.SOURCE);
      final String filter = Params.getParam(args, Params.FILTER);
      if (new File(target).exists()) {
        new R4R5MapTester().testMaps(target, source, filter);
      }
    } else {
      System.out.println("Unknown SpecialMode "+specialMode);
    }
  }
}
