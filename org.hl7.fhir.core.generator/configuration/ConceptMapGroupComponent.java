
  public SourceElementComponent getOrAddElement(String code) {
    for (SourceElementComponent e : getElementList()) {
      if (code.equals(e.getCode())) {
        return e;
      }
    }
    return addElement().setCode(code);
  }
