package org.hl7.fhir.convertors.advisors.interfaces;

import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseExtension;
import org.hl7.fhir.r5.model.FhirPublication;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdvisor30<T extends IBaseExtension> extends BaseAdvisor {
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
                             @Nonnull FhirPublication publication) {
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
                            @Nonnull Type type) throws FHIRException {
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
