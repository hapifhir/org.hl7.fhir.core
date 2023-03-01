public String getAttributeUri(String code) {
  if (code == null) {
    return null;
  }
  for (AdditionalAttributeComponent aa : getAdditionalAttribute()) {
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
  
  for (AdditionalAttributeComponent aa : getAdditionalAttribute()) {
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
  for (PropertyComponent prop : getProperty()) {
    if (code.equals(prop.getCode())) {
      return true;
    }          
  }
  for (AdditionalAttributeComponent prop : getAdditionalAttribute()) {
    if (code.equals(prop.getCode())) {
      return true;
    }          
  }
  return false;
}

private String tail(String uri) {
  return uri.contains("/") ? uri.substring(uri.lastIndexOf("/")+1) : uri;
}