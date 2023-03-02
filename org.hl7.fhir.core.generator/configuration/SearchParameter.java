  public boolean supportsCopyright() {
    return true;
  }
  

  public boolean hasBase(String value) { 
    if (this.base == null)
      return false;
    for (Enumeration<VersionIndependentResourceTypesAll> v : this.base)
      if (v.getCode().equals(value)) // code
        return true;
    return false;
  }
  