package org.hl7.fhir.validation.ai;

public class CodeAndTextValidationResult {
  private CodeAndTextValidationRequest request;
  private boolean isValid;
  private String explanation;
  private String confidence;
  protected CodeAndTextValidationResult(CodeAndTextValidationRequest request, boolean isValid, String explanation, String confidence) {
    super();
    this.request = request;
    this.isValid = isValid;
    this.explanation = explanation;
    this.confidence = confidence;
  }
  public CodeAndTextValidationRequest getRequest() {
    return request;
  }
  public boolean isValid() {
    return isValid;
  }
  public String getExplanation() {
    return explanation;
  }
  public String getConfidence() {
    return confidence;
  }
  public String summary() {
    return (isValid ? "Valid" : "Invalid") +" ("+confidence+") : "+explanation;
  }

}