public PropertyComponent getProperty(String code) {
    for (PropertyComponent pd : getProperty()) {
      if (pd.getCode().equalsIgnoreCase(code))
        return pd;
    }
    return null;
  }

  public ConceptDefinitionComponent getDefinitionByCode(String code) {
    return getDefinitionByCode(getConcept(), code);
  }

  private ConceptDefinitionComponent getDefinitionByCode(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent t : list) {
      if (code.equals(t.getCode())) {
        return t;
      }
      ConceptDefinitionComponent cc = getDefinitionByCode(t.getConcept(), code);
      if (cc != null) {
        return cc;
      }
    }
    return null;
  }