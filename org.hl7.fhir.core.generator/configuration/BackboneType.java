  public void checkNoModifiers(String noun, String verb) throws FHIRException {
        if (hasModifierExtension()) {
          throw new FHIRException("Found unknown Modifier Exceptions on "+noun+" doing "+verb);
        }
        
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
