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
    getModifierExtension().add(ex);    
  }


   @Override
   public Extension getExtensionByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     Extension res = super.getExtensionByUrl(theUrl);
     if (res != null) {
       retVal.add(res);
     }
     for (Extension next : getModifierExtension()) {
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
     for (int i = getModifierExtension().size()-1; i >= 0; i--) {
       if (theUrl.equals(getExtension().get(i).getUrl()))
         getExtension().remove(i);
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
     for (Extension next : getModifierExtension()) {
       if (theUrl.equals(next.getUrl())) {
         retVal.add(next);
       }
     }
     return java.util.Collections.unmodifiableList(retVal);
   }
   