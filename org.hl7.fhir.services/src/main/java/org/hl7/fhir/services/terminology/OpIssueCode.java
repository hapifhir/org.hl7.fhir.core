package org.hl7.fhir.services.terminology;

public enum OpIssueCode {
  NotInVS, ThisNotInVS, InvalidCode, Display, DisplayComment, NotFound, CodeRule, VSProcessing, InferFailed, StatusCheck, InvalidData, CodeComment, VersionError, CacheIdUnknown;

  public String toCode() {
    switch (this) {
      case CacheIdUnknown: return "cache-id-unknown";
      case CodeRule: return "code-rule";
      case Display: return "invalid-display";
      case DisplayComment: return "display-comment";
      case InferFailed: return "cannot-infer";
      case InvalidCode: return "invalid-code";
      case NotFound: return "not-found";
      case NotInVS: return "not-in-vs";
      case InvalidData: return "invalid-data";
      case StatusCheck: return "status-check";
      case ThisNotInVS: return "this-code-not-in-vs";
      case VSProcessing: return "vs-invalid";
      case CodeComment: return "code-comment";
      case VersionError: return "version-error";
      default:
        return "??";
    }
  }
}
