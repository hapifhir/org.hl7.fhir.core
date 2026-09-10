  
  
  @Override 
  public String toString() {
    String srvr = hasExtension(ExtensionDefinitions.EXT_ISSUE_SERVER) ? " (from "+getExtensionString(ExtensionDefinitions.EXT_ISSUE_SERVER)+")" : "";
    String ctxt = hasExtension(ExtensionDefinitions.EXT_ISSUE_ISSUE_CTXT) ? " (context: "+getExtensionString(ExtensionDefinitions.EXT_ISSUE_ISSUE_CTXT)+")" : "";
    if (getExpressionList().size() == 1) {
      return getSeverity().toCode()+"/"+getCode().toCode()+" @ "+getExpressionList().get(0)+(hasDiagnostics() ? " "+getDiagnostics() : "")+": "+getDetails().getText()+ctxt+srvr;
    } else {
      return getSeverity().toCode()+"/"+getCode().toCode()+" @ "+getExpressionList()+(hasDiagnostics() ? " "+getDiagnostics() : "")+": "+getDetails().getText()+ctxt+srvr;
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
