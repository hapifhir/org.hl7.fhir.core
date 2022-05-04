package org.hl7.fhir.r5.utils.validation;

/**
 * Indicates where the IValidatorResourceFetcher will attempt to fetch a
 * resource, and provides the reason.
 *
 * @see IValidatorResourceFetcher
 */
public interface IValidatorCanonicalResourceFetchPolicy {
  /**
   *
   * @return true if the IValidatorResourceFetcher will attempt to fetch
   * the canonical resource.
   */
  public boolean fetchesCanonicalResource();

  /**
   *
   * @return a human-readable reason why the resource cannot be fetched.
   * This will be ignored if fetchesCanonicalResource is false.
   */
  public String fetchPolicyReason();
}
