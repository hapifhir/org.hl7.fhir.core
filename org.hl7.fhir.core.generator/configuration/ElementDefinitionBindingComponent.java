  public boolean hasAdditional(ElementDefinitionBindingAdditionalComponent ab) {
    if (hasAdditional()) {
      for (ElementDefinitionBindingAdditionalComponent t : getAdditionalList()) {
        if (Base.compareDeep(t, ab, false)) {
          return true;
        }
      }
    }
    return false;
  }
