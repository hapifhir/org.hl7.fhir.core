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


  private String webPath;
  public String getWebPath() {
    return webPath;
  }
  public void setWebPath(String webPath) {
    this.webPath = webPath;
  }
  
  // when possible, the source package is considered when performing reference resolution. 
  
  private PackageInformation sourcePackage;

  public boolean hasSourcePackage() {
    return sourcePackage != null;
  }

  public PackageInformation getSourcePackage() {
    return sourcePackage;
  }

  public void setSourcePackage(PackageInformation sourcePackage) {
    this.sourcePackage = sourcePackage;
  }
  
   /** 
   * @return  the logical ID part of this resource's id 
   * @see IdType#getIdPart() 
   */ 
  public String getIdPart() { 
    return getIdElement().getIdPart(); 
  } 
 