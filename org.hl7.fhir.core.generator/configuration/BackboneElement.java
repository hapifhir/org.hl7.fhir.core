  public void checkNoModifiers(String noun, String verb) throws FHIRException {
        if (hasModifierExtension()) {
          throw new FHIRException("Found unknown Modifier Exceptions on "+noun+" doing "+verb);
        }
        
  }
  
  public void addModifierExtension(String url, DataType value) {
    if (isDisallowExtensions())
      throw new Error("Extensions are not allowed in this context");
    Extension ex = new Extension();
    ex.setUrl(url);
    ex.setValue(value);
    getModifierExtensionList().add(ex);    
  }


   @Override
   public Extension getExtensionByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     Extension res = super.getExtensionByUrl(theUrl);
     if (res != null) {
       retVal.add(res);
     }
     for (Extension next : getModifierExtensionList()) {
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
  
   @Override
   public void removeExtension(String theUrl) {
     for (int i = getModifierExtensionList().size()-1; i >= 0; i--) {
       if (theUrl.equals(getExtensionList().get(i).getUrl()))
         getExtensionList().remove(i);
     }
     super.removeExtension(theUrl);
   }
   

   /**
    * Returns an unmodifiable list containing all extensions on this element which 
    * match the given URL.
    * 
    * @param theUrl The URL. Must not be blank or null.
    * @return an unmodifiable list containing all extensions on this element which 
    * match the given URL
    */
   @Override
   public List<Extension> getExtensionsByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     retVal.addAll(super.getExtensionsByUrl(theUrl));
     for (Extension next : getModifierExtensionList()) {
       if (theUrl.equals(next.getUrl())) {
         retVal.add(next);
       }
     }
     return java.util.Collections.unmodifiableList(retVal);
   }

  public boolean hasExtension(String... theUrls) {
    for (Extension next : getModifierExtensionList()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    return super.hasExtension(theUrls);
  }

  public boolean hasExtension(Extension ext) {
    for (Extension t : getModifierExtensionList()) {
      if (Base.compareDeep(t, ext, false)) {
        return true;
      }
    }
    return super.hasExtension(ext);
  }

  public void copyExtensions(org.hl7.fhir.model.core.BackboneElement src, String... urls) {
    super.copyExtensions(src,urls);
    for (Extension e : src.getModifierExtensionList()) {
      if (Utilities.existsInList(e.getUrl(), urls)) {
        addModifierExtension(e.copy(Base.COPY_DATA));
      }
    }
  }

  // required to implement the HAPI cross-version interface IBaseHasModifierExtensions (fixed method name)
  @Override
  public List<Extension> getModifierExtension() {
    return getModifierExtensionList();
  }


  // required to implement the HAPI cross-version interface IBaseHasExtensions (fixed method name)
  @Override
  public List<Extension> getExtension() {
    return getExtensionList();
  }

  public List<Extension> getExtensionsByUrl(String... theUrls) {
    ArrayList<Extension> retVal = new ArrayList<>();

    for (Extension next : getExtension()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        retVal.add(next);
      }
    }
    return java.util.Collections.unmodifiableList(retVal);
  }