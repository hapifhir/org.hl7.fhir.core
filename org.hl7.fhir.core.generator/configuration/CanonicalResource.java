  @Override
  public String toString() {
    return fhirType()+"["+getUrl()+(hasVersion() ? "|"+getVersion(): "")+"]";
  }
  
  public String present() {
    if (hasTitle())
      return getTitle();
    if (hasName())
      return getName();
    return toString();
  }
  
  public String getVUrl() {
    return getUrl() + (hasVersion() ? "|"+getVersion() : "");
  }      
  
  public boolean supportsCopyright() {
    return true;
  }
  
  public String getVersionedUrl() {
    return hasVersion() ? getUrl()+"|"+getVersion() : getUrl();
  }  
  

  public String oid() {
    for (Identifier id : getIdentifierList()) {
      if (id.getValue().startsWith("urn:oid:")) {
        return id.getValue().substring(8);
      }
    }
    return null;
  }

  public String getOid() {
    for (Identifier id : getIdentifierList()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:")) {
        return id.getValue().substring(8);
      }
    }
    return null;
  }

  public String present(String lang) {
    if (hasUserData(UserDataNames.render_presentation)) {
      return getUserString(UserDataNames.render_presentation);
    }
    if (hasTitleElement()) {
      for (Entry<String, String> t : ExtensionUtilities.getLanguageTranslations(getTitleElement()).entrySet()) {
        if (t.getKey().equals(lang)) {
          return t.getValue();
        }
      }
    }
    if (hasNameElement()) {
      for (Entry<String, String> t : ExtensionUtilities.getLanguageTranslations(getNameElement()).entrySet()) {
        if (t.getKey().equals(lang)) {
          return t.getValue();
        }
      }
    }
    return present();
  }
