  public void checkNoModifiers(String noun, String verb) throws FHIRException {
        if (hasModifierExtension()) {
          throw new FHIRException("Found unknown Modifier Exceptions on "+noun+" doing "+verb);
        }
        
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

  public void copyExtensions(org.hl7.fhir.model.core.BackboneType src, String... urls) {
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