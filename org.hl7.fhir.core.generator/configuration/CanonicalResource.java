  @Override
  public String toString() {
    return fhirType()+"["+getUrl()+"]";
  }
  
  public String present() {
    if (hasTitle())
      return getTitle();
    if (hasName())
      return getName();
    return toString();
  }
  
  public String getVUrl() {
    return getUrl() + (hasVersion() ? "|"+getVersion() : "");
  }      
  
  public boolean supportsCopyright() {
    return true;
  }
  