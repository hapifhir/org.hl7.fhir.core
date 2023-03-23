
  public ElementDefinition getElementByPath(String path) {
    if (path == null) {
      return null;
    }
    for (ElementDefinition ed : getElement()) {
      if (path.equals(ed.getPath()) || (path+"[x]").equals(ed.getPath())) {
        return ed;
      }
    }
    return null;
  }


  public ElementDefinition getElementById(String id) {
    if (id == null) {
      return null;
    }
    for (ElementDefinition ed : getElement()) {
      if (id.equals(ed.getId())) {
        return ed;
      }
    }
    return null;
  }
