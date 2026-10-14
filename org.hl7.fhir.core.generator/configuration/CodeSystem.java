public PropertyComponent getProperty(String code) {
    for (PropertyComponent pd : getPropertyList()) {
      if (pd.getCode().equalsIgnoreCase(code))
        return pd;
    }
    return null;
  }

  public ConceptDefinitionComponent getDefinitionByCode(String code) {
    return getDefinitionByCode(getConceptList(), code);
  }

  private ConceptDefinitionComponent getDefinitionByCode(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent t : list) {
      if (code.equals(t.getCode())) {
        return t;
      }
      ConceptDefinitionComponent cc = getDefinitionByCode(t.getConceptList(), code);
      if (cc != null) {
        return cc;
      }
    }
    return null;
  }