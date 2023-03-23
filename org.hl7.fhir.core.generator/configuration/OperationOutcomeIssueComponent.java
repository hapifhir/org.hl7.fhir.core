  
  
  public boolean isSuccess() {
    for (OperationOutcomeIssueComponent iss : getIssue()) {
      if (iss.isWarningOrMore() || iss.getCode() != IssueType.INFORMATIONAL) {
        return false;
      }
      if (iss.isInformationorLess() || iss.getCode() != IssueType.INFORMATIONAL) {
        return true;
      }
    }
    return false;
  }
  
  @Override 
  public String toString() { 
    if (getExpression().size() == 1) { 
      return getExpression().get(0)+" "+getDiagnostics()+" "+getSeverity().toCode()+"/"+getCode().toCode()+": "+getDetails().getText(); 
    } else { 
      return getExpression()+" "+getDiagnostics()+" "+getSeverity().toCode()+"/"+getCode().toCode()+": "+getDetails().getText(); 
    } 
  } 
  
  public boolean isWarningOrMore() {
    switch (getSeverity()) {
    case FATAL: return true;
    case ERROR: return true;
    case WARNING: return true;
    case INFORMATION: return false;
    case SUCCESS: return false;
    case NULL: return false;
    default: return false;
    }
  }
  public  boolean isInformationorLess() {
    switch (getSeverity()) {
    case FATAL: return false;
    case ERROR: return true;
    case WARNING: return false;
    case INFORMATION: return true;
    case SUCCESS: return true;
    case NULL: return true;
    default: return false;
    }
  }  
