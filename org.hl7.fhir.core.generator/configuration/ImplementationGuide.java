
  public String getFullPackageId() {
    String prefix = hasExtension(ExtensionConstants.EXT_PACKAGE_SCOPE) ? "@"+ ExtensionUtilities.readStringExtension(this, ExtensionConstants.EXT_PACKAGE_SCOPE) +"/" : "";
    return prefix + getPackageId();
  }

  public ImplementationGuideDefinitionPageComponent getPageByName(String name) {
    if (!hasDefinition() || !getDefinition().hasPage()) {
      return null;
    }
    return getPageByName(getDefinition().getPage(), name);
  }


  private ImplementationGuideDefinitionPageComponent getPageByName(ImplementationGuideDefinitionPageComponent page, String name) {
    if (name.equals(page.getName())) {
      return page;
    }
    for (ImplementationGuideDefinitionPageComponent t : page.getPageList()) {
      ImplementationGuideDefinitionPageComponent r = getPageByName(t, name);
      if (r != null) {
        return r;
      }
    }
    return null;
  }
