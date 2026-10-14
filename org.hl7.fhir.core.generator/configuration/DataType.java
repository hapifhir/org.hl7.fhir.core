
public String getTranslation(String l) throws FHIRException {
  for (Extension e : getExtensionList()) {
    if (e.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
      String lang = ExtensionUtilities.readStringExtension(e, "lang");
      if (lang.equals(l))
        return e.getExtensionString("content");
    }
  }
  return primitiveValue();
}

public boolean isTranslatable() {
  return false;
}