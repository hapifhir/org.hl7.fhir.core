package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.CacheToken;

public class CodingValidationRequest {
  private Coding coding;
  private ValidationResult result;
  private CacheToken cacheToken;
  private String vs;
  private ValueSet vsObj;

  public CodingValidationRequest(Coding coding) {
    super();
    this.coding = coding;
  }

  public CodingValidationRequest(Coding coding, String vs) {
    super();
    this.coding = coding;
    this.vs = vs;
  }

  public CodingValidationRequest(Coding coding, ValueSet vsObj) {
    super();
    this.coding = coding;
    this.vsObj = vsObj;
  }

  public String getVs() {
    return vs;
  }

  public ValueSet getVsObj() {
    return vsObj;
  }

  public ValidationResult getResult() {
    return result;
  }

  public void setResult(ValidationResult result) {
    this.result = result;
  }

  public Coding getCoding() {
    return coding;
  }

  public boolean hasResult() {
    return result != null;
  }

  /**
   * internal logic; external users of batch validation should ignore this property
   * 
   * @return
   */
  public CacheToken getCacheToken() {
    return cacheToken;
  }

  /**
   * internal logic; external users of batch validation should ignore this property
   * 
   * @param cacheToken
   */
  public void setCacheToken(CacheToken cacheToken) {
    this.cacheToken = cacheToken;
  }


}