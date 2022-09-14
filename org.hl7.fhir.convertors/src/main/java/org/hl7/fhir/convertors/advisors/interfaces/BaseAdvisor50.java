package org.hl7.fhir.convertors.advisors.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseExtension;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.FhirPublication;

public abstract class BaseAdvisor50<T extends IBaseExtension> extends BaseAdvisor {
  private final List<CodeSystem> cslist = new ArrayList<>();

  public final List<CodeSystem> getCslist() {
    return this.cslist;
  }

  public void handleCodeSystem(@Nonnull CodeSystem tgtcs,
                               @Nonnull ValueSet source) {
    tgtcs.setId(source.getId());
    tgtcs.setValueSet(source.getUrl());
    this.cslist.add(tgtcs);
  }

  public boolean ignoreEntry(@Nonnull Bundle.BundleEntryComponent src,
                             @Nonnull FhirPublication targetVersion) {
    return false;
  }

  public CodeSystem getCodeSystem(@Nonnull ValueSet src) throws FHIRException {
    return null;
  }

  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull Extension ext) throws FHIRException {
    return ((ext.getUrl() != null) && (this.ignoreExtension(path, ext.getUrl()))
      || (this.ignoreType(path, ext.getValue())));
  }

  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull T ext) throws FHIRException {
    return ((ext.getUrl() != null) && this.ignoreExtension(path, ext.getUrl()))
      || (this.ignoreType(path, ext.getValue()));
  }

  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    return false;
  }

  public boolean ignoreType(@Nonnull String path,
                            @Nonnull DataType type) throws FHIRException {
    return false;
  }

  public boolean ignoreType(@Nonnull String path,
                            @Nonnull Object type) throws FHIRException {
    return false;
  }

  public boolean useAdvisorForExtension(@Nonnull String path,
                                        @Nonnull Extension ext) throws FHIRException {
    return false;
  }

  public boolean useAdvisorForExtension(@Nonnull String path,
                                        @Nonnull T ext) throws FHIRException {
    return false;
  }

  public void handleExtension(@Nonnull String path,
                              @Nonnull Extension src,
                              @Nonnull T tgt) throws FHIRException {
  }

  public void handleExtension(@Nonnull String path,
                              @Nonnull T src,
                              @Nonnull Extension tgt) throws FHIRException {
  }
}
