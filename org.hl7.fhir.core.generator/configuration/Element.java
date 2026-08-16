 @Override
  public String getIdBase() {
    return getId();
  }
  
  @Override
  public void setIdBase(String value) {
    setId(value);
  }
  
  public void addExtension(String url, DataType value) {
    if (disallowExtensions)
      throw new Error("Extensions are not allowed in this context");
    Extension ex = new Extension();
    ex.setUrl(url);
    ex.setValue(value);
    getExtensionList().add(ex);    
  }

 
  /**
   * Returns an extension if one (and only one) matches the given URL.
   * 
   * Note: BackbdoneElements override this to look in matching Modifier Extensions too
   * 
   * @param theUrl The URL. Must not be blank or null.
   * @return the matching extension, or null
   */
   public Extension getExtensionByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     for (Extension next : getExtensionList()) {
       if (theUrl.equals(next.getUrl())) {
         retVal.add(next);
       }
     }
     if (retVal.size() == 0)
       return null;
     else {
       org.apache.commons.lang3.Validate.isTrue(retVal.size() == 1, "Url "+theUrl+" must have only one match");
       return retVal.get(0);
     }
   }
  
   /**
    * Remove any extensions that match (by given URL).
    * 
    * Note: BackbdoneElements override this to remove from Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    */
   public void removeExtension(String theUrl) {
     for (int i = getExtensionList().size()-1; i >= 0; i--) {
       if (theUrl.equals(getExtensionList().get(i).getUrl()))
         getExtensionList().remove(i);
     }
   }
   
   /**
    * This is used in the FHIRPath engine to record that no extensions are allowed for this item in the context in which it is used.
    * todo: enforce this....
    */
    private boolean disallowExtensions;

    public boolean isDisallowExtensions() {
      return disallowExtensions;
    }

    public Element setDisallowExtensions(boolean disallowExtensions) {
      this.disallowExtensions = disallowExtensions;
      return this;
    }

    public Element noExtensions() {
      this.disallowExtensions = true;
      return this;
    }
  
   /**
    * Returns an unmodifiable list containing all extensions on this element which 
    * match the given URL.
    * 
    * Note: BackbdoneElements override this to add matching Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    * @return an unmodifiable list containing all extensions on this element which match the given URL
    */
   public List<Extension> getExtensionsByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     for (Extension next : getExtensionList()) {
       if (theUrl.equals(next.getUrl())) {
         retVal.add(next);
       }
     }
     return java.util.Collections.unmodifiableList(retVal);
   }
   
   /**
    * Returns an true if this element has an extension that matchs the given URL.
    * 
    * Note: BackbdoneElements override this to check Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    */
   public boolean hasExtension(String theUrl) {
     return !getExtensionsByUrl(theUrl).isEmpty(); 
   }

   /**
    * Returns the value as a string if this element has only one extension that matches the given URL, and that can be converted to a string.
    * 
    * Note: BackbdoneElements override this to check Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    */
   public String getExtensionString(String theUrl) throws FHIRException {
     List<Extension> ext = getExtensionsByUrl(theUrl); 
     if (ext.isEmpty()) 
       return null; 
     if (ext.size() > 1) 
       throw new FHIRException("Multiple matching extensions found for extension '"+theUrl+"'");
     if (!ext.get(0).getValue().isPrimitive())
       throw new FHIRException("Extension '"+theUrl+"' could not be converted to a string");
     return ext.get(0).getValue().primitiveValue();
   }


  public StandardsStatus getStandardsStatus() {
    return ExtensionUtilities.getStandardsStatus(this);
  }
  
  public void setStandardsStatus(StandardsStatus status) {
    ExtensionUtilities.setStandardsStatus(this, status, null, null);
  }

   public FhirPublication getFHIRPublicationVersion() {
     return FhirPublication.R6;
   }


   public void copyExtensions(org.hl7.fhir.model.core.Element src, String... urls) {
     for (Extension e : src.getExtensionList()) {
       if (Utilities.existsInList(e.getUrl(), urls)) {
         addExtension(e.copy(Base.COPY_DATA));
       }
     }
   }

   public void copyNewExtensions(org.hl7.fhir.model.core.Element src, String... urls) {
     for (Extension e : src.getExtensionList()) {
       if (Utilities.existsInList(e.getUrl(), urls) && !hasExtension(e.getUrl())) {
         addExtension(e.copy(Base.COPY_DATA));
       }
     }
   }

   

  // required to implement the HAPI cross-version interface IBaseHasExtensions (fixed method name)
  @Override
  public List<Extension> getExtension() {
    return getExtensionList();
  }
