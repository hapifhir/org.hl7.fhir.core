  public String getAttributeUri(String code) {
    if (code == null) {
      return null;
    }
    for (AdditionalAttributeComponent aa : getAdditionalAttributeList()) {
      if (code.equals(aa.getCode())) {
        return aa.hasUri() ? aa.getUri() : code;
      }
    }
    return code;
  }

  public String registerAttribute(String uri) {
    if (uri == null) {
      return null;
    }
    // determine a default code
    String t = tail(uri).replace("-", "");
    if (Utilities.noString(t))
      t = "code";
    String code = t;
    int i = 0;
    while (alreadyExistsAsCode(code)) {
      i++;
      code = t + i;
    }

    for (AdditionalAttributeComponent aa : getAdditionalAttributeList()) {
      if (uri.equals(aa.getUri())) {
        if (!aa.hasCode()) {
          aa.setCode(code);
        }
        return aa.getCode();
      }
    }
    addAdditionalAttribute().setUri(uri).setCode(code);
    return code;
  }

  private boolean alreadyExistsAsCode(String code) {
    for (PropertyComponent prop : getPropertyList()) {
      if (code.equals(prop.getCode())) {
        return true;
      }
    }
    for (AdditionalAttributeComponent prop : getAdditionalAttributeList()) {
      if (code.equals(prop.getCode())) {
        return true;
      }
    }
    return false;
  }

  private String tail(String uri) {
    return uri.contains("/") ? uri.substring(uri.lastIndexOf("/")+1) : uri;
  }


  public ConceptMapGroupComponent forceGroup(String su, String tu) {
    for (ConceptMapGroupComponent g : getGroupList()) {
      if (su.equals(g.getSource()) && tu.equals(g.getTarget())) {
        return g;
      }
    }
    ConceptMapGroupComponent g = addGroup();
    g.setSource(su);
    g.setTarget(tu);
    return g;

  }

  public List<ConceptMapGroupComponent> getGroups(String su) {
    List<ConceptMapGroupComponent> res = new ArrayList<>();

    for (ConceptMapGroupComponent g : getGroupList()) {
      if (su.equals(g.getSource())) {
        res.add(g);
      }
    }
    return res;
  }