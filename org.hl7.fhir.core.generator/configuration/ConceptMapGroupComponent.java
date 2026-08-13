
  public SourceElementComponent getOrAddElement(String code) {
    for (SourceElementComponent e : getElement()) {
      if (code.equals(e.getCode())) {
        return e;
      }
    }
    return addElement().setCode(code);
  }
