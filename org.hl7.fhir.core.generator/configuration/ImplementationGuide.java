
  public String getFullPackageId() {
    String prefix = "";
    for (Extension e : getExtensionsForRead()) {
      if (ExtensionConstants.EXT_PACKAGE_SCOPE.equals(e.getUrl())) {
        prefix = "@"+ ExtensionUtilities.readStringExtension(this, ExtensionConstants.EXT_PACKAGE_SCOPE) +"/";
        break;
      }
    }
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
