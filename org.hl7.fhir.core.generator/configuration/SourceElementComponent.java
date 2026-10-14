
  public TargetElementComponent addTarget(String code, ConceptMapRelationship relationship) {
    TargetElementComponent tgt = addTarget();
    tgt.setCode(code);
    tgt.setRelationship(relationship);
    return tgt;
  }

  public boolean hasTargetCode(String code) {
    for (TargetElementComponent tgt : getTargetList()) {
      if (code.equals(tgt.getCode())) {
        return true;
      }
    }
    return false;
  }