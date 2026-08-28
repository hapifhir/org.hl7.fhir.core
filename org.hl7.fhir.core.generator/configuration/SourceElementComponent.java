
  public TargetElementComponent addTarget(String code, ConceptMapRelationship relationship) {
    TargetElementComponent tgt = addTarget();
    tgt.setCode(code);
    tgt.setRelationship(relationship);
    return tgt;
  }