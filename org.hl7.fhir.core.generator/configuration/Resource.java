@Override
  public String getIdBase() {
    return getId();
  }
  
  @Override
  public void setIdBase(String value) {
    setId(value);
  }
  public abstract ResourceType getResourceType();
  
  public String getLanguage(String defValue) {
    return hasLanguage() ? getLanguage() : defValue;
  }