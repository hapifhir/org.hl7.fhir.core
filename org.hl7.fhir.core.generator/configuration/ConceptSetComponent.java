
  public boolean hasConcept(String code) {
    for (ConceptReferenceComponent c : getConceptList()) {
      if (code.equals(c.getCode())) {
        return true;
      }
    }
    return false;
  }
