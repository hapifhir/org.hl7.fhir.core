public void checkNoModifiers(String noun, String verb) throws FHIRException {
        if (hasModifierExtension()) {
          throw new FHIRException("Found unknown Modifier Exceptions on "+noun+" doing "+verb);
        }
        
  }

  public void addExtension(String url, DataType value) {
    Extension ex = new Extension();
    ex.setUrl(url);
    ex.setValue(value);
    getExtension().add(ex);    
  }
  



  public boolean hasExtension(String url) {
    for (Extension e : getExtension())
      if (url.equals(e.getUrl()))
        return true;
    return false;
    }
    
       public Extension getExtensionByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     for (Extension next : getExtension()) {
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
  
      public Resource getContained(String ref) {
        if (ref == null)
          return null;
        
        if (ref.startsWith("#"))
          ref = ref.substring(1);
        for (Resource r : getContained()) {
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
      for (Extension next : getExtension()) {
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
      for (Extension next : getModifierExtension()) {
        if (theUrl.equals(next.getUrl())) {
          retVal.add(next);
        }
      }
      return Collections.unmodifiableList(retVal);
    }