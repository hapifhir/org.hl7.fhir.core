package org.hl7.fhir.validation.cli.tasks;

import java.io.File;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.service.utils.EngineMode;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorOutputType;
import org.hl7.fhir.validation.special.PackageReGenerator.ExpansionPackageGeneratorScope;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

@Slf4j
public class RePackageTask extends ValidationEngineTask {

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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return validationContext.getMode() == EngineMode.RE_PACKAGE;
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/tx-pack.txt");
  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    boolean json = validationContext.getFormat() != FhirFormat.XML;
    String output = validationContext.getOutput();
    File f = ManagedFileAccess.file(output);
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
      case "ig" :
        scope = ExpansionPackageGeneratorScope.IG_ONLY;
        break;
      case "igs" : 
        scope = ExpansionPackageGeneratorScope.ALL_IGS;
        break;
      case "core" :
        scope = ExpansionPackageGeneratorScope.EVERYTHING;
        break;
      default: 
        log.warn("Unknown scope "+args[c+1]);
      }
    }
    IWorkerContext ctxt = validationEngine.getContext();
    PackageReGenerator ep = new PackageReGenerator().setContext(ctxt).setScope(scope);
    ep.setNpmId(validationContext.getPackageName());
    for (String s : validationContext.getIgs()) {
      ep.addPackage(s);
    }
    if (validationContext.getExpansionParameters() != null) {
      validationEngine.loadExpansionParameters(validationContext.getExpansionParameters());
    }
    ep.setOutput(output).setOutputType(t).setJson(json);
    ep.setModes(validationContext.getModeParams());
    ep.generateExpansionPackage();
  }
}
