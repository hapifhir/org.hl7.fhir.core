package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.SystemExitManager;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.PackageServer;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.utils.Params;
import org.hl7.fhir.validation.packages.PackageCacheDownloader;
import org.hl7.fhir.validation.special.TxTester;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class PreloadCacheTask extends StandaloneTask {
  @Override
  public String getName() {
    return "preloadCache";
  }

  @Override
  public String getDisplayName() {
    return "Pre-load Package Cache";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(CliContext cliContext, String[] args) {
    return Params.hasParam(args, Params.PRELOAD_CACHE);
  }

  @Override
  public void printHelp(PrintStream out) {

  }

  @Override
  public void executeTask(CliContext cliContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    PackageVisitor pv = new PackageCacheDownloader();
    pv.visitPackages();
  }


}
