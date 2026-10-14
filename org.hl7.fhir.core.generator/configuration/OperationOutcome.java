  public boolean supportsCopyright() {
    return true;
  }


  public boolean isSuccess() {
    for (OperationOutcomeIssueComponent iss : getIssueList()) {
      if (iss.isWarningOrMore() || iss.getCode() != IssueType.INFORMATIONAL) {
        return false;
      }
      if (iss.isInformationorLess() || iss.getCode() != IssueType.INFORMATIONAL) {
        return true;
      }
    }
    return false;
  }
  