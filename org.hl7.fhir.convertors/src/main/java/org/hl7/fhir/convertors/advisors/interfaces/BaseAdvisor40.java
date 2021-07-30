package org.hl7.fhir.convertors.advisors.interfaces;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseExtension;
import org.hl7.fhir.r4.model.*;
import org.jetbrains.annotations.NotNull;

public abstract class BaseAdvisor40<T extends IBaseExtension> extends BaseAdvisor {

  public boolean ignoreEntry(@NotNull Bundle.BundleEntryComponent src, @NotNull org.hl7.fhir.r5.model.FhirPublication targetVersion) {
    return false;
  }

  public void handleCodeSystem(@NotNull CodeSystem tgtcs, @NotNull ValueSet source) throws FHIRException {
  }

  public CodeSystem getCodeSystem(@NotNull ValueSet src) throws FHIRException {
    return null;
  }

  public boolean ignoreExtension(@NotNull String path, @NotNull Extension ext) throws FHIRException {
    return ((ext.getUrl() != null) && (this.ignoreExtension(path, ext.getUrl()))
      || (this.ignoreType(path, ext.getValue())));
  }

  public boolean ignoreExtension(@NotNull String path, @NotNull T ext) throws FHIRException {
    return ((ext.getUrl() != null) && this.ignoreExtension(path, ext.getUrl()))
      || (this.ignoreType(path, ext.getValue()));
  }

  public boolean ignoreExtension(@NotNull String path, @NotNull String url) throws FHIRException {
    return false;
  }

  public boolean ignoreType(@NotNull String path, @NotNull Type type) throws FHIRException {
    return false;
  }

  public boolean ignoreType(@NotNull String path, @NotNull Object type) throws FHIRException {
    return false;
  }

  public boolean useAdvisorForExtension(@NotNull String path, @NotNull Extension ext) throws FHIRException {
    return false;
  }

  public boolean useAdvisorForExtension(@NotNull String path, @NotNull T ext) throws FHIRException {
    return false;
  }

  public void handleExtension(@NotNull String path, @NotNull Extension src, @NotNull T tgt) throws FHIRException {
  }

  public void handleExtension(@NotNull String path, @NotNull T src, @NotNull Extension tgt) throws FHIRException {
  }
}
