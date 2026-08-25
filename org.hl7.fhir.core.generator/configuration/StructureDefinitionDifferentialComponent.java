
  public ElementDefinition getElementByPath(String path) {
    if (path == null) {
      return null;
    }
    for (ElementDefinition ed : getElementList()) {
      if (path.equals(ed.getPath()) || (path+"[x]").equals(ed.getPath())) {
        return ed;
      }
    }
    return null;
  }
