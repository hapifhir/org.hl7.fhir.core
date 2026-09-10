
  /**
   * Read-only access to the extensions, for code that only searches them. Unlike
   * getExtensionList() this does not create (and store) an empty BaseList when there are none,
   * which both allocates and mutates elements that callers treat as read-only.
   */
  public List<Extension> getExtensionsForRead() {
    return this.extensionList == null ? java.util.Collections.<Extension>emptyList() : this.extensionList;
  }

  /**
   * Read-only access to the modifier extensions, for code that only searches them.
   * See Element.getExtensionsForRead().
   */
  public List<Extension> getModifierExtensionsForRead() {
    return this.modifierExtensionList == null ? java.util.Collections.<Extension>emptyList() : this.modifierExtensionList;
  }
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
    for (Extension next : getModifierExtensionsForRead()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    for (Extension next : getExtensionsForRead()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasExtension(String url) {
    for (Extension e : getExtensionsForRead())
      if (url.equals(e.getUrl()))
        return true;
    return false;
    }
    
    public Extension getExtensionByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     for (Extension next : getExtensionsForRead()) {
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

      for (Extension next : getExtensionsForRead()) {
        if (Utilities.existsInList(next.getUrl(), theUrls)) {
          retVal.add(next);
        }
      }
      for (Extension next : getModifierExtensionsForRead()) {
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
      for (Extension next : getExtensionsForRead()) {
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
      for (Extension next : getModifierExtensionsForRead()) {
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
    for (Extension e : getModifierExtensionsForRead()) {
      if (url.equals(e.getUrl()) && e.hasValue() && e.getValue().isPrimitive()) {
        return true;
      }
    }
    for (Extension e : getExtensionsForRead()) {
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

    /**
     * The single extension matching the URL, or null if there is none. Scans in place rather
     * than building a list - see Element.getSingleExtensionByUrl().
     */
    protected Extension getSingleExtensionByUrl(String theUrl) throws FHIRException {
      org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must be provided with a value");
      return soleExtension(getExtensionsForRead(), theUrl, null);
    }

    /**
     * @param found an extension already matched by a caller scanning another list, or null
     */
    protected static Extension soleExtension(List<Extension> list, String theUrl, Extension found) throws FHIRException {
      for (Extension next : list) {
        if (theUrl.equals(next.getUrl())) {
          if (found != null) {
            throw new FHIRException("Multiple matching extensions found for extension '"+theUrl+"'");
          }
          found = next;
        }
      }
      return found;
    }

  public String getExtensionString(String theUrl) throws FHIRException {
    Extension ext = getSingleExtensionByUrl(theUrl);
    if (ext == null)
      return null;
    if (!ext.hasValue())
      return null;
    if (!ext.getValue().isPrimitive())
      throw new FHIRException("Extension '" + theUrl + "' could not be converted to a string");
    return ext.getValue().primitiveValue();
  }

  public String getExtensionString(String... theUrls) throws FHIRException {
    for (String url : theUrls) {
      if (hasExtension(url)) {
        return getExtensionString(url);
      }
    }
    return null;
  }


