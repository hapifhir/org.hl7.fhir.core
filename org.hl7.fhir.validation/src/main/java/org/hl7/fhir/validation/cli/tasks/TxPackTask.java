package org.hl7.fhir.validation.cli.tasks;

import java.io.File;
import java.io.PrintStream;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.utils.Display;
import org.hl7.fhir.validation.cli.utils.EngineMode;
import org.hl7.fhir.validation.special.ExpansionPackageGenerator;
import org.hl7.fhir.validation.special.ExpansionPackageGenerator.ExpansionPackageGeneratorOutputType;
import org.hl7.fhir.validation.special.ExpansionPackageGenerator.ExpansionPackageGeneratorScope;

public class TxPackTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "tx-pack";
  }

  @Override
  public String getDisplayName() {
    return "Generate a terminology pack";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return cliContext.getMode() == EngineMode.TX_PACK;
  }

  @Override
  public void printHelp(PrintStream out) {
    Display.displayHelpDetails(out,"help/tx-pack.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception { 
    String pid = cliContext.getPackageName();
    boolean json = cliContext.getFormat() != FhirFormat.XML;
    String output = cliContext.getOutput();
    File f = new File(output);
    ExpansionPackageGeneratorOutputType t = ExpansionPackageGeneratorOutputType.FOLDER;
    if (f.exists() && f.isDirectory()) {
      t = ExpansionPackageGeneratorOutputType.FOLDER;
    } else if (output.endsWith(".zip")) {
      t = ExpansionPackageGeneratorOutputType.ZIP;
    } else if (output.endsWith(".tgz")) {
      t = ExpansionPackageGeneratorOutputType.TGZ;
    } 
    ExpansionPackageGeneratorScope scope = ExpansionPackageGeneratorScope.IG_ONLY;
    int c = -1;
    for (int i = 0; i < args.length; i++) {
      if ("-scope".equals(args[i])) {
        c = i;
      }
    }
    if (c < args.length - 1) {
      switch (args[c+1].toLowerCase()) {
      case "ig" : scope = ExpansionPackageGeneratorScope.IG_ONLY;
      case "igs" : scope = ExpansionPackageGeneratorScope.ALL_IGS;
      case "core" : scope = ExpansionPackageGeneratorScope.EVERYTHING;
      default: 
        System.out.println("Unknown scope "+args[c+1]);
      }
    }
    IWorkerContext ctxt = validationEngine.getContext();
    ExpansionPackageGenerator ep = new ExpansionPackageGenerator().setContext(ctxt).setPackageId(pid).setScope(scope);
    if (cliContext.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(cliContext.getExpansionParameters());
    }
    ep.setOutput(output).setOutputType(t);
    ep.generateExpansionPackage();
  }
}
