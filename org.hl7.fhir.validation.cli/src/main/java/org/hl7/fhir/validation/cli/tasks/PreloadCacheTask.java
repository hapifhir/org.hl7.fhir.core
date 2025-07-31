package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.packages.PackageCacheDownloader;
import org.slf4j.Logger;

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
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return Params.hasParam(args, Params.PRELOAD_CACHE);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception {
    PackageVisitor pv = new PackageCacheDownloader();
    pv.visitPackages();
  }


}
