package org.hl7.fhir.model;


import javax.annotation.Nonnull;

/**
 * This provides a context for R6 objects. It provides the following things:
 *  - the version being implemented
 *  - registration of additional sets of objects
 */
public interface IModelContext {
  /**
   * This returns the main/core version that is in use - a draft version of R6 or more recent
   * @return
   */
  @Nonnull
  public String getFHIRVersion();

  /**
   * Handle to a class that holds information about the support for the FHIR standard in this
   * @return
   */
  @Nonnull
  public ModelContextInformation getContextInformation();

  boolean isCompatibleModelContext(IModelContext modelContext);

  String describeContext();
}
