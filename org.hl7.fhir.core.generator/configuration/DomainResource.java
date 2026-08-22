public void checkNoModifiers(String noun, String verb) throws FHIRException {
        if (hasModifierExtension()) {
          throw new FHIRException("Found unknown Modifier Exceptions on "+noun+" doing "+verb);
        }
        
  }

  public void addExtension(String url, DataType value) {
    Extension ex = new Extension();
    ex.setUrl(url);
    ex.setValue(value);
    getExtensionList().add(ex);    
  }
  



  public boolean hasExtension(String... theUrls) {
    for (Extension next : getModifierExtensionList()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    for (Extension next : getExtensionList()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasExtension(String url) {
    for (Extension e : getExtensionList())
      if (url.equals(e.getUrl()))
        return true;
    return false;
    }
    
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
    public List<Extension> getExtensionsByUrl(String... theUrls) {
      ArrayList<Extension> retVal = new ArrayList<>();

      for (Extension next : getExtension()) {
        if (Utilities.existsInList(next.getUrl(), theUrls)) {
          retVal.add(next);
        }
      }
      for (Extension next : getModifierExtension()) {
        if (Utilities.existsInList(next.getUrl(), theUrls)) {
          retVal.add(next);
        }
      }
      return java.util.Collections.unmodifiableList(retVal);
    }


public Resource getContained(String ref) {
        if (ref == null)
          return null;
        
        if (ref.startsWith("#"))
          ref = ref.substring(1);
        for (Resource r : getContainedList()) {
          if (r.getId().equals(ref)) 
            return r;
        }
        return null;
      }

    /**
     * Returns a list of extensions from this element which have the given URL. Note that
     * this list may not be modified (you can not add or remove elements from it)
     */
    public List<Extension> getExtensionsByUrl(String theUrl) {
      org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must be provided with a value");
      ArrayList<Extension> retVal = new ArrayList<Extension>();
      for (Extension next : getExtensionList()) {
        if (theUrl.equals(next.getUrl())) {
          retVal.add(next);
        }
      }
      return Collections.unmodifiableList(retVal);
    }

    /**
     * Returns a list of modifier extensions from this element which have the given URL. Note that
     * this list may not be modified (you can not add or remove elements from it)
     */
    public List<Extension> getModifierExtensionsByUrl(String theUrl) {
      org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must be provided with a value");
      ArrayList<Extension> retVal = new ArrayList<Extension>();
      for (Extension next : getModifierExtensionList()) {
        if (theUrl.equals(next.getUrl())) {
          retVal.add(next);
        }
      }
      return Collections.unmodifiableList(retVal);
    }


    public StandardsStatus getStandardsStatus() {
      return ExtensionUtilities.getStandardsStatus(this);
    }
    
    public void setStandardsStatus(StandardsStatus status) {
      ExtensionUtilities.setStandardsStatus(this, status, null, null);
    }


  // required to implement the HAPI cross-version interfaces IBaseHasExtensions,
  // IBaseHasModifierExtensions and IDomainResource (fixed method names)
  @Override
  public List<Extension> getExtension() {
    return getExtensionList();
  }

  @Override
  public List<Extension> getModifierExtension() {
    return getModifierExtensionList();
  }

  @Override
  public List<Resource> getContained() {
    return getContainedList();
  }

  public boolean hasPrimitiveExtension(String url) {
    for (Extension e : getModifierExtension()) {
      if (url.equals(e.getUrl()) && e.hasValue() && e.getValue().isPrimitive()) {
        return true;
      }
    }
    for (Extension e : getExtension()) {
      if (url.equals(e.getUrl()) && e.hasValue() && e.getValue().isPrimitive()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the value as a string if this element has only one extension that matches the given URL, and that can be converted to a string.
   * <p>
   * Note: BackboneElements override this to check Modifier Extensions too
   *
   * @param theUrl The URL. Must not be blank or null.
   */
  public String getExtensionString(String theUrl) throws FHIRException {
    List<Extension> ext = getExtensionsByUrl(theUrl);
    if (ext.isEmpty())
      return null;
    if (ext.size() > 1)
      throw new FHIRException("Multiple matching extensions found for extension '" + theUrl + "'");
    if (!ext.get(0).hasValue())
      return null;
    if (!ext.get(0).getValue().isPrimitive())
      throw new FHIRException("Extension '" + theUrl + "' could not be converted to a string");
    return ext.get(0).getValue().primitiveValue();
  }

  public String getExtensionString(String... theUrls) throws FHIRException {
    for (String url : theUrls) {
      if (hasExtension(url)) {
        return getExtensionString(url);
      }
    }
    return null;
  }


