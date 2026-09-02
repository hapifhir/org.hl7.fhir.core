  
  
  @Override 
  public String toString() { 
    if (getExpressionList().size() == 1) { 
      return getExpressionList().get(0)+" "+getDiagnostics()+" "+getSeverity().toCode()+"/"+getCode().toCode()+": "+getDetails().getText(); 
    } else { 
      return getExpressionList()+" "+getDiagnostics()+" "+getSeverity().toCode()+"/"+getCode().toCode()+": "+getDetails().getText(); 
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

  public void resetPath(String root, String newRoot) {
    for (StringType st : getExpressionList()) {
      if (st.hasValue() && st.getValue().startsWith(root+".")) {
        st.setValue(newRoot+st.getValue().substring(root.length()));
      }
    }
  }
