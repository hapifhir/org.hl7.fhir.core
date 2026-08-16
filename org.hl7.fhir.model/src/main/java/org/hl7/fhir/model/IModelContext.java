package org.hl7.fhir.model;

/**
 * This provides a context for R6 objects. It provides the following things:
 *  - the version being implemented
 *  - registration of additional sets of objects
 */
public interface IModelContext {
  /**
   * This returns the version that is in use - a draft version of R6 or more recent
   * @return
   */
  public String getVersion();
}
