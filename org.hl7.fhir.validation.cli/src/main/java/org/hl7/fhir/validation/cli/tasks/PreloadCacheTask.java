package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.packages.PackageCacheDownloader;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return Params.hasParam(args, Params.PRELOAD_CACHE);
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    PackageVisitor pv = new PackageCacheDownloader();
    pv.visitPackages();
  }


}
