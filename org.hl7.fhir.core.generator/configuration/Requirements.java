
  public RequirementsStatementComponent findStatement(String key) {
    for (RequirementsStatementComponent t : getStatementList()) {
      if (key.equals(t.getKey())) {
        return t;
      }
    }
    return null;
  }
  public boolean hasActor(String url) {
    for (var actor : getActorList()) {
      if (actor.getReference().equals(url)) {
        return true;
      }
    }
    return false;
  }

